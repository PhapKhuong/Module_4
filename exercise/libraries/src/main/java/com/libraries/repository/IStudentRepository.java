package com.libraries.repository;

import com.libraries.model.Student;
import com.libraries.query.LibraryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = LibraryQuery.SELECT_STUDENT_BY_NAME, nativeQuery = true)
    Page<Student> findStudentPageByName(Pageable pageable, @Param("student_name") String studentName);
}
