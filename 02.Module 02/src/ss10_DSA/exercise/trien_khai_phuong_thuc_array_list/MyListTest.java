package ss10_DSA.exercise.trien_khai_phuong_thuc_array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        System.out.println("Add - method: ");
        listInteger.add(0, 10);
        listInteger.add(1, 11);
        listInteger.add(2, 12);
        listInteger.add(3, 13);
        listInteger.add(3, 14);
        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 3: " + listInteger.get(3));
        System.out.println("element 2: " + listInteger.get(2));

        System.out.println("\nRemove - method");
        System.out.println("element is removed: " + listInteger.remove(3));
        System.out.println("element 3: " + listInteger.get(3));
        System.out.println("element 2: " + listInteger.get(2));

        System.out.println("\nSize - method:");
        System.out.println("The number of elements in this list: " + listInteger.size());
        System.out.println("element is removed: " + listInteger.remove(3));
        System.out.println("The number of elements in this list: " + listInteger.size());

        System.out.println("\nClone");
        MyList<Integer> cloneListInteger = new MyList<>();
        cloneListInteger = (MyList<Integer>) listInteger.clone();
        for (int i = 0; i < cloneListInteger.size(); i++) {
            System.out.println("element of cloneListInteger " + i + ": " + cloneListInteger.get(i));
        }
        cloneListInteger.add(2, 22);

        System.out.println("\nChange cloneListInteger");
        System.out.println("element of 2 of listInteger: " + listInteger.get(2));
        System.out.println("element of 2 of cloneListInteger: " + cloneListInteger.get(2));

        System.out.println("\nContains - method");
        System.out.print("12 in listInteger: ");
        System.out.println(listInteger.contains(12));
        System.out.print("20 in listInteger: ");
        System.out.println(listInteger.contains(20));

        System.out.println("\nIndexOf - method");
        System.out.println("indexOf 12 in listInteger: " + listInteger.indexOf(12));
        System.out.println("indexOf 10 in listInteger: " + listInteger.indexOf(10));
        System.out.println("indexOf 30 in listInteger: " + listInteger.indexOf(30));

        System.out.println("\nBoolean add(E e) - method");
        System.out.println("add 13 in listInteger: " + listInteger.add(13));
        System.out.println("add 10 in listInteger: " + listInteger.add(10));
        System.out.println(listInteger.get(3));

        System.out.println("\nEnsureCapacity: ");
        listInteger.ensureCapacity(15);

        System.out.println("\nClear - method");
        listInteger.clear();
    }
}
