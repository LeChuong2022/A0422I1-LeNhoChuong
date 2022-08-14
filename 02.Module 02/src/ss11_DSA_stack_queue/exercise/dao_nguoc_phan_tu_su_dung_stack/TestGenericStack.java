package ss11_DSA_stack_queue.exercise.dao_nguoc_phan_tu_su_dung_stack;

public class TestGenericStack {
    public static void main(String[] args) {
        // Reverse number in stack
        System.out.println("1. Reverse number in stack: ");
        MyGenericStack<Integer> numberStack = new MyGenericStack<>();
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int temp : arrays) {
            System.out.print(temp + " ");
            numberStack.push(temp);
        }
        for (int i = 0; i < arrays.length; i++) {
            if (!numberStack.isEmpty())
                arrays[i] = numberStack.pop();
        }
        System.out.println();
        for (int temp : arrays) {
            System.out.print(temp + " ");
        }

        // Reverse string
        System.out.println("\n2. Reverse String: ");
        String string = "abcdefghijk";
        MyGenericStack<String> stringStack = new MyGenericStack<>();
        for (int i = 0; i < string.length(); i++) {
            String temp = String.valueOf(string.charAt(i));
            stringStack.push(temp);
        }
        string = "";
        while (!stringStack.isEmpty()) {
            string = string.concat(stringStack.pop());
        }
        System.out.println(string);
    }
}
