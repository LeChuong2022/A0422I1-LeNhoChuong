package codegym.vn.service;

import java.util.List;
import codegym.vn.bean.Student;

public interface IStudentService {
    void createOrUpdate(Student s);

    Student findById(String id);

    List<Student> findAll();

    void deleteById(String id);
}
