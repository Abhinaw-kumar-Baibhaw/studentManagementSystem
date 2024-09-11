package com.example.StudentManagement.dto;

//import com.example.StudentManagement.enums.MobileEnum;
import com.example.StudentManagement.enums.MobileEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobileDto {

    private Long mobileId;
    private String mobileNumber;
    private MobileEnum mobileType;

//    @JsonBackReference
//    @JsonIgnore
//    private StudentDto student;
}
