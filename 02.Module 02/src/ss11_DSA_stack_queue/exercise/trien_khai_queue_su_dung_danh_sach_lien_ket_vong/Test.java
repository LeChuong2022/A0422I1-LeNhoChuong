package ss11_DSA_stack_queue.exercise.trien_khai_queue_su_dung_danh_sach_lien_ket_vong;

public class Test {
    public static void main(String[] args) {
        Solution queue = new Solution();

        queue.enQueue(14);
        queue.enQueue(22);
        queue.enQueue(24);
        queue.enQueue(26);
        queue.enQueue(30);
        queue.enQueue(32);

        queue.displayQueue();
        System.out.println("\ndelete");
        queue.deQueue();
        queue.displayQueue();

        System.out.println("\ndelete");
        queue.deQueue();
        queue.displayQueue();
    }
}
