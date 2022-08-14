package ss11_DSA_stack_queue.practice.trien_khai_queue_ArrayList;

public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.printArray();

        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.printArray();

        queue.dequeue();
        queue.dequeue();
        queue.printArray();

        queue.enqueue(24);
        queue.printArray();

        queue.dequeue();
        queue.printArray();

        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);

        queue.printArray();

    }
}
