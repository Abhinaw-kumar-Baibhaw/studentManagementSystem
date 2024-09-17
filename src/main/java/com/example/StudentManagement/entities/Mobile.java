package com.example.StudentManagement.entities;
import com.example.StudentManagement.enums.MobileEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobileNumber;


    @Enumerated(EnumType.STRING)
    private MobileEnum mobileType;


    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
}
