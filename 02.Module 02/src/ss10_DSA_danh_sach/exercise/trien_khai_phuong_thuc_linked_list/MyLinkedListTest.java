package ss10_DSA_danh_sach.exercise.trien_khai_phuong_thuc_linked_list;


public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<Integer> ll = new MyLinkedList(8);
        System.out.println("add(int index, E element): void ----");
        ll.add(0, 4);
        ll.add(1, 5);
        ll.printList();

        System.out.println("\naddFirst ------");
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.printList();

        System.out.println("\naddLast ------");
        ll.addLast(20);
        ll.addLast(21);
        ll.addLast(22);
        ll.printList();

        System.out.println("\nremove(int index) ------");
        System.out.println("remove index 0: " + ll.remove(0));
        ll.printList();
        System.out.println("remove index 3: " + ll.remove(3));
        ll.printList();

        System.out.println("\nremove(Object) ------ ");
        Object test = 100;
        System.out.println("remove 100: " + ll.remove(test));
        ll.printList();
        test = 21;
        System.out.println("remove 21: " + ll.remove(test));
        ll.printList();

        System.out.println("\nsize of linked list: " + ll.size());

        System.out.println("\nclone ");
        MyLinkedList<Integer> cloneMyLinkedList = ll.clone();
        cloneMyLinkedList.printList();

        System.out.println("\nchange clone");
        cloneMyLinkedList.addFirst(13);
        System.out.println("Original LinkedList: ");
        ll.printList();
        System.out.println("CloneLinkedList: ");
        cloneMyLinkedList.printList();

        System.out.println("\nContain: ");
        System.out.println("13 in CloneLinkedList: " + cloneMyLinkedList.contains(13));
        System.out.println("23 in CloneLinkedList: " + cloneMyLinkedList.contains(23));

        System.out.println("\nIndexOf: ");
        System.out.println("13 index: " + cloneMyLinkedList.indexOf(13));
        System.out.println("20 index: " + cloneMyLinkedList.indexOf(20));
        System.out.println("23 index: " + cloneMyLinkedList.indexOf(23));

        System.out.println("\nadd(E e): boolean");
        System.out.println("add 13 in cloneMyLinkedList: " + cloneMyLinkedList.add(13));
        cloneMyLinkedList.printList();
        System.out.println("add 24 in cloneMyLinkedList: " + cloneMyLinkedList.add(24));
        cloneMyLinkedList.printList();

        System.out.println("\nget(int i)");
        System.out.println("Get value at index 2 from cloneMyLinkedList: " + cloneMyLinkedList.get(2));
        System.out.println("Get value at index 7 from cloneMyLinkedList: " + cloneMyLinkedList.get(7));
        System.out.println("Get value at index 0 from cloneMyLinkedList: " + cloneMyLinkedList.get(0));

        System.out.println("\ngetFirst: " + cloneMyLinkedList.getFirst());

        System.out.println("\ngetLast: " + cloneMyLinkedList.getLast());

        System.out.println("Clear cloneMyLinkedList");
        cloneMyLinkedList.clear();
        System.out.println("size: " + cloneMyLinkedList.size());
        cloneMyLinkedList.removeFirst();
    }
}
