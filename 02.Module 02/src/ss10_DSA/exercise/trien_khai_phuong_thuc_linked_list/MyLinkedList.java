package ss10_DSA.exercise.trien_khai_phuong_thuc_linked_list;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public MyLinkedList() {

    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;

        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(Object data) {
        if (tail == null) {
            head = tail = new Node(data);
        } else {
            tail.next = new Node(data);
            tail = tail.next
            tail.next = null;
        }
        numNodes++;
    }

    public E removeFirst() {
        if (numNodes == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) tail = null;
            return (E) temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) return null;
        else if (numNodes == 1) {
            Node temp = head;
            head = temp = null;
            numNodes = 0;
            return (E) temp.data;
        } else {
            Node temp = head;
            for (int i = 0; i < numNodes - 2; i++) {
                temp = temp.next;
            }
            Node holder = tail;
            tail = temp;
            tail.next = null;
            numNodes--;
            return (E) holder.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node previous = head;
            Node temp;
            for (int i = 0; i < index - 1 && previous.next != null; i++) {
                previous = previous.next;
            }
            temp = previous.next;
            previous.next = temp.next;
            numNodes--;
            return (E) temp.data;
        }
    }

    public boolean remove(Object data) {
        int index = indexOf((E) data);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> clone = new MyLinkedList<E>();
        for (int i = 0; i < numNodes; i++) {
            clone.add(i, this.get(i));
        }
        return clone;
    }

    public boolean contains(E o) {
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(this.get(i)))
                return true;
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(this.get(i)))
                return i;
        }
        return -1;
    }

    public boolean add(E e) {
        if (contains(e))
            return false;
        addLast(e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {

    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp;
    }

    public E getFirst() {
        return (E) head;
    }

    public E getLast() {
        return (E) tail;
    }

    public void clear() {
        Node temp = head;
        for (int i = 0; i < numNodes - 2; i++) {
            temp = temp.next;
            temp = null;
        }
        head = tail = null;
        numNodes = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
