public class SingleLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SingleLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    public void display (){
        Node<E> current = head;
        while(current.getNext()!=null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
        System.out.println(current.getElement());
    }

    public void getAtIndex(int index) {
        Node<E>  current= head;
        boolean check = false;
        for (int i = 0; i < this.size; i++) {
            if(current.getElement() != null){
                if(i == index){
                    System.out.println(current.getElement());
                    check = true;
                    break;
                }
                current = current.getNext();
            }
        }
        if(!check){
            System.out.println("Element was not found");
        }
    }
    public E secondToLast(){
        Node<E> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current.getElement();
    }
    public void addAtInd(int index,E element){
        Node<E>  current= head;
        Node<E> newNode = new Node(element,null);
        if(index == 0){
            Node<E> temp = head;
            head = newNode;
            newNode.setNext(temp);
        }else{
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        Node<E> temp = current.getNext();
        current.setNext(newNode);
        newNode.setNext(temp);}
    }

    public void removeAtInd(int index){
        Node<E>  current= head;
        if(index == 0){
            head = head.getNext();
        }
        else {
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
    }
    }
    public void rotate(){
        if(head == null || head == tail){
            return;
        }
        Node<E> current = head;
        head = head.getNext();
        tail.setNext(current);
        current.setNext(null);
        tail = current;
    }
    public void removeDup(){

    }
}
