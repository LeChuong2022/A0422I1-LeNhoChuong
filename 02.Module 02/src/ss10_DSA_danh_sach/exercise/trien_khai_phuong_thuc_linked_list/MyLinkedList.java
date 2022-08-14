package ss10_DSA_danh_sach.exercise.trien_khai_phuong_thuc_linked_list;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {

    }

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
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

    public void add(int index, E data) {
        if (index >= numNodes || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + numNodes);
        else if (index == 0)
            addFirst(data);
        else {
            Node temp = head;
            Node newNode = new Node(data);
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            numNodes++;
        }
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data) {
        numNodes++;
        add(numNodes - 1, data);
        numNodes--;
    }

    public E removeFirst() {
        if (numNodes == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + numNodes);
        else if (index == 0) return removeFirst();
        else {
            Node temp = head;
            Node valueRemove;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            valueRemove = temp.next;
            temp.next = valueRemove.next;
            numNodes--;
            return (E) valueRemove.data;
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
        MyLinkedList<E> clone = new MyLinkedList<>();
        clone.numNodes++;
        for (int i = 0; i < numNodes; i++) {
            clone.add(i, get(i));
        }
        clone.numNodes--;
        return clone;
    }

    public boolean contains(E o) {
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(get(i)))
                return true;
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(get(i)))
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
        if (index < 0 || index >= numNodes)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + numNodes);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        return (E) get(numNodes - 1);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
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
