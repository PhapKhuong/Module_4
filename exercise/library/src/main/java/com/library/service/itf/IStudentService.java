package com.library.service.itf;

import com.library.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudentList();

    void addStudent(Student student);

    void updateStudent(Student student);

    Page<Student> findStudentPageByName(Pageable pageable, String studentName);
}
