package com.example.StudentManagement.dto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto2 {

    private StudentDto StudentDto;
    private String generateToken;

    public StudentDto2(StudentDto studentDto, String generateToken) {
        this.StudentDto = studentDto;
        this.generateToken = generateToken;
    }

}
