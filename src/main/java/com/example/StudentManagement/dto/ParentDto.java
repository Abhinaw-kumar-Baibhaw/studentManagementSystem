package com.example.StudentManagement.dto;

//import com.example.StudentManagement.entities.AddressEntity;
//import com.example.StudentManagement.entities.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParentDto {

    private Long id;
    private String fatherName;
    private String motherName;
    private String fatherOccupation;
//    private Mobile mobile;
//    private AddressEntity address;
}
