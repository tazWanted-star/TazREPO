public class DoubleLinkedList<E> {
    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element;          // reference to the element stored at this node
        private Node<E> prev;       // reference to the previous node in the list
        private Node<E> next;       // reference to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoubleLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }


    public E removeLast() {
        if (isEmpty()) return null; // nothing to remove
        return remove(trailer.getPrev()); // last element is before trailer
    }

    // private update methods
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void displayForward(){
        Node<E> current = header;
        while(current.getNext().getNext() != null){
                System.out.println(current.getNext().getElement());
            current = current.getNext();
        }
    }

    public void displayBackward(){
        Node<E> current = trailer;
        while(current.getPrev().getPrev() != null){
            System.out.println(current.getPrev().getElement());
            current = current.getPrev();
        }
    }
    public void replace(int index, E e){
        Node <E> current = header;
        for (int i = 0; i < size; i++) {
                if(i == index){
                    addBetween(e, current.getPrev(), current.getNext());
                    break;
                }
                current = current.getNext();
        }
    }

    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        addBetween(e, current.getPrev(), current);
        size++;
    }

    public void delete(int index){
        if(index < 0 || index > size) {
            System.out.println("Out of range");
        }else if(index == 0){
            removeFirst();
        }
        else{
            Node<E> current = header;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            remove(current);
            size--;
        }
    }

    public boolean isPlaindrome(){
        Node<E> first = header.getNext();
        Node<E> last = trailer.getPrev();
        boolean check = true;
        while (first != null && last != null && first != last && first.getPrev() != last){
            if(!first.getElement().equals(last.getElement())){
                check = false;
                break;
            }
            first = first.getNext();
            last = last.getPrev();
        }
        return check;
    }

}
