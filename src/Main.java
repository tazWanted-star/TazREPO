public class Main {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.addFirst("Call of duty");
        linkedList.addFirst("Battlefield");
        linkedList.addFirst("Assassin's creed");
        linkedList.addFirst("Middle Earth");

        linkedList.displayBackward();
    }
}