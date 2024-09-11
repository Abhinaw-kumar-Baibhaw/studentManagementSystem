package com.example.StudentManagement.dto;
import com.example.StudentManagement.entities.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {

    private Long id;
    private String courseName;
    private String courseDescription;
    private int courseFee;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int duration;

//    @JsonManagedReference
//    @JsonIgnore
    private List<DepartmentDto> departments;


//    @JsonManagedReference
//    @JsonIgnore
//    private List<StudentDto> students;
}
