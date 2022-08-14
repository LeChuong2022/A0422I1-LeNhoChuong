package ss11_DSA_stack_queue.exercise.to_chuc_DL_demerging_su_dung_queue;

public class StudentList {
    private String name;
    private String sex;
    private String birthday;

    public StudentList(String name, String sex, String birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getName(){
        return name;
    }

    public boolean isFemale(){
        if (sex.equals("female"))
            return true;
        return false;
    }
    @Override
    public String toString(){
        return name + " " + sex + " " + birthday;
    }
}
