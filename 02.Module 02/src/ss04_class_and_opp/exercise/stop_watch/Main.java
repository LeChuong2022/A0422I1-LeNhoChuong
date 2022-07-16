package ss04_class_and_opp.exercise.stop_watch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch time = new StopWatch();
        int choice = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Menu: ");
        System.out.println("1. Reset time ");
        System.out.println("2. Stop time ");
        System.out.println("0. Exit");
        System.out.println("Start time: " + time.getStartTime());
        do {
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    time.start();
                    System.out.println("Start time: " + time.getStartTime());
                    break;
                case 2:
                    time.stop();
                    System.out.println("Stop time: " + time.getEndTime());
                    System.out.println("Elapsed time: " + time.getElapsedTime());
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice != 0);
    }
}
