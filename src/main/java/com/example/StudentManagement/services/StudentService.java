package com.example.StudentManagement.services;

import com.example.StudentManagement.dto.MobileDto;
import com.example.StudentManagement.dto.StudentDto;
//import com.example.StudentManagement.entities.Mobile;
import com.example.StudentManagement.dto.StudentDto2;
import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repo.StudentRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public StudentDto2 addStudent(StudentDto studentDto);

    public StudentDto updateStudent(StudentDto studentDto, Long id);

    public StudentDto findById(Long id);

    public StudentDto findByEmail(String email);

//    public List<StudentDto> findByKeyword(String keyword);

//    public StudentDto findByStudentDepartment(long studentId);

//    public StudentDto findByCourse(long id);

//    public StudentDto findByMobile(String mobile);

public List<StudentDto> getStudentsByCourseName(String courseName);

    public String deleteById(Long id);

    public StudentDto showProfile(Long id);

    public List<StudentDto> getAllData();

}
