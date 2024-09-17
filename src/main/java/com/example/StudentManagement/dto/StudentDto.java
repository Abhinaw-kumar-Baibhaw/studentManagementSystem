    package com.example.StudentManagement.dto;
    import com.fasterxml.jackson.annotation.JsonInclude;
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


        private List<AddressDto> addresses;

        private List<MobileDto> mobiles;

        private DepartmentDto departmentDto;

        private CourseDto courses;


    }
