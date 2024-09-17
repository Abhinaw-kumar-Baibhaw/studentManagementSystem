package com.example.StudentManagement.repo;

import com.example.StudentManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByEmail(String email);

    @Modifying
    @Query("DELETE FROM Student s WHERE s.studentId = :id")
    void deleteByStudentId(@Param("id") Long id);


    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseName = :courseName")
    List<Student> findByCourseName(@Param("courseName") String courseName);
}
