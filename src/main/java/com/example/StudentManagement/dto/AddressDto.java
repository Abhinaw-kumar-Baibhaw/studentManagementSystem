package com.example.StudentManagement.dto;

import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.enums.AddressEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private Long addressId;
    private String streetName;
    private String city;
    private String district;
    private String state;
    private String country;
    private int zipcode;
    private AddressEnum addressType;
//    @JsonBackReference
//    @JsonIgnore
//    private StudentDto student;
}
