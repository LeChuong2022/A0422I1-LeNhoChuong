package codegym.vn.service.impl;

import codegym.vn.bean.Student;
import codegym.vn.repository.IStudentRepository;
import codegym.vn.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;

    @Override
    public void createOrUpdate(Student s) {
        studentRepository.createOrUpdate(s);
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByName(String searchName) {
        return studentRepository.findByName(searchName);
    }


}
