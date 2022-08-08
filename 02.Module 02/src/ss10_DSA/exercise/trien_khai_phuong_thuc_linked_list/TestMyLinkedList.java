package ss10_DSA.exercise.trien_khai_phuong_thuc_linked_list;


public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList <Integer> ll = new MyLinkedList(8);
        System.out.println("add(int index, E element): void ----");
        ll.add(1, 4);
        ll.add(2,5);
        ll.printList();

        System.out.println("\naddFirst ------");
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.printList();

//        System.out.println("\naddLast ------");
        ll.addLast(20);
//        ll.addLast(21);
        ll.printList();

//        ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);
//
//        ll.add(4, 10);
//        ll.add(4, 9);
//        ll.printList();
    }
}
