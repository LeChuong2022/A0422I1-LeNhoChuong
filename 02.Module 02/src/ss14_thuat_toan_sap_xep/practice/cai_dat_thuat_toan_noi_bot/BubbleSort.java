package ss14_thuat_toan_sap_xep.practice.cai_dat_thuat_toan_noi_bot;

public class BubbleSort {
//    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
//    static int[] list = {1, 2, 4, 3};
    static int[] list = {3,4,5,2,1};
    static int count1 = 0;
    static int count2 = 0;

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++) {
            /*Array may be sorted and next pass not needed */

            needNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    /*Swap list[i] with list[i+1]*/
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    needNextPass = true; /*Next pass still need*/

                }
                count1++;
            }
            count2++;
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%4d", list[i]);
        }
        System.out.println("\nSo lan lap trong 2 vong for:" + count1);
        System.out.println("\nSo lan lap trong 1 vong for:" + count2);
    }
}


