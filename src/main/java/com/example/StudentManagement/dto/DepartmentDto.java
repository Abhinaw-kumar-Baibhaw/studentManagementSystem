package com.example.StudentManagement.dto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {

    private Long id;
    private String departmentName;
    private String description;

//    @JsonBackReference
//    @JsonIgnore
//    private CourseDto courses;

}
