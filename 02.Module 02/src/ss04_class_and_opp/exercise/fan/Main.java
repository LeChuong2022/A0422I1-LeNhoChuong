package ss04_class_and_opp.exercise.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(fan1.getFAST());
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println("Fan1: " + fan1.display());
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.getMEDIUM());
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println("Fan2: " + fan2.display());
        Fan fan3 = new Fan();
        System.out.println("Fan3: " + fan3.display());
    }
}
