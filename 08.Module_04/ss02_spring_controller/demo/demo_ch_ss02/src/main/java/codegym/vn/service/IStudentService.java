package codegym.vn.service;

import codegym.vn.bean.Student;

import java.util.List;

public interface IStudentService {
    void createOrUpdate(Student s);

    Student findById(String id);

    List<Student> findAll();

    void deleteById(String id);

    List<Student> findByName(String searchName);

}
