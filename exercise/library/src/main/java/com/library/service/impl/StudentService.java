package com.library.service.impl;

import com.library.model.Student;
import com.library.repository.IStudentRepository;
import com.library.service.itf.IStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private IStudentRepository studentRepository;

    private StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> findStudentPageByName(Pageable pageable, String studentName) {
        return studentRepository.findStudentPageByName(pageable, studentName);
    }
}
