package ss05_access_modifier.exercise.xay_dung_lop_chi_ghi;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {
    }

    public void setName(String name) {  //public + protected + default: ok
        this.name = name;
    }

    public void setClasses(String classes) { //public + protected + default: ok
        this.classes = classes;
    }

    public String display() {
        return "Name: " + name + ". Classes: " + classes;
    }
}
