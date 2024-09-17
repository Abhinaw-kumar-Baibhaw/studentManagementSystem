package com.example.StudentManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseDescription;
    private int courseFee;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int duration;

    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Department> departments;


    @OneToMany(mappedBy = "courses",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;
}
