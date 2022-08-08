package ss10_DSA.exercise.trien_khai_phuong_thuc_array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCAPA() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        size++;
        indexOutOfBoundsException(index);
        if (size == elements.length) {
            ensureCAPA();
        }
        for (int i = size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    public E remove(int index) {
        indexOutOfBoundsException(index);
        size--;
        E e = (E) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        return e;
    }

    public int size() {
        return size;
    }

    public E get(int i) {
        indexOutOfBoundsException(i);
        return (E) elements[i];
    }

    public MyList<E> clone() {
        MyList<E> clone = new MyList<>();
        for (int i = 0; i < size; i++) {
            clone.add(i, (E) elements[i]);
        }
        return clone;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]) || (o == null && elements[i] == null))
                return true;
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]))
                return i;
        }
        return -1;
    }

    public boolean add(E e) {
        if (indexOf(e) == -1) {
            if (size == elements.length)
                ensureCAPA();
            elements[size++] = e;
            return true;
        }
        return false;
    }

    public void indexOutOfBoundsException(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
    }

    public void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, minCapacity);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
