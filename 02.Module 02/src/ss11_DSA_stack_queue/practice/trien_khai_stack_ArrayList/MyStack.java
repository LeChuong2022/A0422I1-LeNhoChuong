package ss11_DSA_stack_queue.practice.trien_khai_stack_ArrayList;

public class MyStack {
    private int[] arr;
    private int size;
    private int index;

    public MyStack(int size) {
        arr = new int[size];
        this.size = size;
        index = 0;
    }

    public void setIndex(int index){  // Test
        this.index = index;
    }

    public void push(int element) {
        if (isFull())
            throw new StackOverflowError("Stack is full");
        arr[index] = element;
        index++;
    }

    public int pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is null");
        return arr[--index];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        if (index == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (index == size)
            return true;
        return false;
    }
}
