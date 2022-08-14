package ss11_DSA_stack_queue.exercise.trien_khai_queue_su_dung_danh_sach_lien_ket_vong;

public class Solution {
    public Queue queue = new Queue();

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (isQueueEmpty())
            queue.front = temp;
        else {
            queue.rear.link = temp;
        }
        queue.rear = temp;
        queue.rear.link = queue.front;
    }

    public Node deQueue() {
        if (isQueueEmpty()) {
            System.out.printf("Queue is empty");
            return null;
        } else if (queue.front == queue.rear) {
            Node temp = queue.front;
            queue.front = queue.rear = null;
            return temp;
        } else {
            Node temp = queue.front;
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
            return temp;
        }
    }

    public boolean isQueueEmpty() {
        if (queue.front == null)
            return true;
        return false;
    }

    public void displayQueue() {
        Node temp = queue.front;
        while (temp.link != queue.front) {
            System.out.println(temp.data + " ");
            temp = temp.link;
        }
        System.out.printf(temp.data + " ");
    }
}
