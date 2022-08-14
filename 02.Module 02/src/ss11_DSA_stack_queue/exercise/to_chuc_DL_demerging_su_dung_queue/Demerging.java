package ss11_DSA_stack_queue.exercise.to_chuc_DL_demerging_su_dung_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        StudentList[] studentLists = new StudentList[8];
        studentLists[0] = new StudentList("Vinh", "male", "01/02/1990");
        studentLists[1] = new StudentList("Thao", "female", "02/02/1990");
        studentLists[2] = new StudentList("Ha", "female", "03/02/1990");
        studentLists[3] = new StudentList("Nam", "male", "04/02/1990");
        studentLists[4] = new StudentList("Thanh", "female", "05/02/1990");
        studentLists[5] = new StudentList("Tuan", "male", "06/02/1990");
        studentLists[6] = new StudentList("Trang", "female", "07/02/1990");
        studentLists[7] = new StudentList("Long", "male", "08/02/1990");
        Queue<StudentList> femaleQueue = new LinkedList<>();
        Queue<StudentList> maleQueue = new LinkedList<>();
        Queue<StudentList> studentQueue = new LinkedList<>();
        for (StudentList student : studentLists) {
            if (student.isFemale())
                femaleQueue.add(student);
            else
                maleQueue.add(student);
        }
        while (!femaleQueue.isEmpty())
            studentQueue.add(femaleQueue.remove());
        while (!maleQueue.isEmpty())
            studentQueue.add(maleQueue.remove());
        System.out.println(studentQueue.toString());
    }
}