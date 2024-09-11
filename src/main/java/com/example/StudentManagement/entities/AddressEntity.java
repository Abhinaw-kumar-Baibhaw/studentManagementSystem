package com.example.StudentManagement.entities;
import com.example.StudentManagement.enums.AddressEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String streetName;
    private String city;
    private String district;
    private String state;
    private String country;
    private int zipcode;

    @Enumerated(EnumType.STRING)
    private AddressEnum addressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
//    @JsonBackReference
//    @JsonIgnore
    private Student student;

}


