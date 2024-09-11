    package com.example.StudentManagement.dto;
    import com.fasterxml.jackson.annotation.JsonBackReference;
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonInclude;
    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import lombok.*;

    import java.time.LocalDate;
    import java.util.Date;
    import java.util.List;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class StudentDto {


        private Long studentId;
        private String name;
        private int age;
        private String email;
        private String password;
        private Date date;
        private String gender;
        private Date registerDate;
        private boolean isVerified;
        private LocalDate createdAt;
        private LocalDate updatedAt;

//        @JsonManagedReference
//        @JsonIgnore
        private List<AddressDto> addresses;

//        @JsonManagedReference
//        @JsonIgnore
        private List<MobileDto> mobiles;

//        @JsonBackReference
//        @JsonIgnore
        private DepartmentDto departmentDto;

//        @JsonBackReference
//        @JsonIgnore
        private CourseDto courses;


    }
