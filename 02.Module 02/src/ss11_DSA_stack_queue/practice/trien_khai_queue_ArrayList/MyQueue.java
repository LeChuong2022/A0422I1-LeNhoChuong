package ss11_DSA_stack_queue.practice.trien_khai_queue_ArrayList;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        capacity = queueSize;
        queueArr = new int[capacity];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity)
            return true;
        return false;
    }

    public boolean isQueueEmpty() {
        if (currentSize == 0)
            return true;
        return false;
    }

    public void enqueue(int item) {
        if (isQueueFull())
            System.out.println("Overflow! Unable to add element: " + item);
        else {
            tail++;
            if (tail == capacity) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue!");
        }
    }

    public void dequeue() {
        if (isQueueEmpty())
            System.out.println("Underflow! Unable to remove element from Queue");
        else {
            head++;
            if (head == capacity) {
                System.out.println("Pop operation done! removed: " + queueArr[head - 1]);
                head = 0;
            } else
                System.out.println("Pop operation code! removed: " + queueArr[head - 1]);
        }
        currentSize--;
    }

    public void printArray() {
        for (int temp : queueArr
        ) {
            System.out.print(temp + " ");
        }
    }
}
