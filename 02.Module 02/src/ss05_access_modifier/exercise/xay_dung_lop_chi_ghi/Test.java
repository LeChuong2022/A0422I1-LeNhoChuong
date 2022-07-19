package ss05_access_modifier.exercise.xay_dung_lop_chi_ghi;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("Student 1: \n   " + student1.display());
        Student student2 = new Student();
        student2.setName("Jack");
        student2.setClasses("C05");
        System.out.println("Student 2: \n   " + student2.display());
    }
}
