package com.example.StudentManagement.service_impl;

import com.example.StudentManagement.config.JwtService;
import com.example.StudentManagement.dto.*;
import com.example.StudentManagement.entities.*;
import com.example.StudentManagement.exceptions.ResourceNotFoundException;
import com.example.StudentManagement.repo.*;
import com.example.StudentManagement.services.StudentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentServiceImplement implements StudentService {


    private final ModelMapper modelMapper;
    private final StudentRepo studentRepo;
    private final DepartmentRepo departmentRepo;
    private final CourseRepo courseRepo;
    private final MobileRepo mobileRepo;
    private final AddressRepo addressRepo;

    @Autowired
    private  final JwtService jwtService;

    public StudentServiceImplement(ModelMapper modelMapper, StudentRepo studentRepo, JwtService jwtService, DepartmentRepo departmentRepo, CourseRepo courseRepo,AddressRepo addressRepo, MobileRepo mobileRepo) {
        this.modelMapper = modelMapper;
        this.studentRepo = studentRepo;
        this.jwtService = jwtService;
        this.departmentRepo = departmentRepo;
        this.courseRepo=courseRepo;
        this.addressRepo=addressRepo;
        this.mobileRepo=mobileRepo;
    }

    @Override
    public StudentDto2 addStudent(StudentDto studentDto) {


        System.out.println("TOTAL RECORD"+studentDto.getCourses());

        Long studentId = studentDto.getStudentId();

        Department department= departmentRepo.findById(studentDto.getDepartmentDto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id :: "+ studentDto.getDepartmentDto().getId()));

        Student studentData = modelMapper.map(studentDto, Student.class);


        Optional<Course> courseId = courseRepo.findById(studentDto.getCourses().getId());

        if(courseId.isPresent()){
            Course course = courseId.get();
            studentData.setCourses(course);
        }
        else {
            throw new RuntimeException("Not Found");
        }


        studentData.setDepartment(department);

        studentData.setRegisterDate(new Date());

        studentData.setCreatedAt(LocalDate.now());

        List<AddressEntity> addresses = setStudentAddress(studentDto, studentData);

        studentData.setAddresses(addresses);

        List<Mobile> mobiles = setStudentMobiles(studentDto, studentData);

        studentData.setMobiles(mobiles);

        Student savedStudent = studentRepo.save(studentData);

        Department departmentData = savedStudent.getDepartment();

        DepartmentDto departmentDto = modelMapper.map(departmentData, DepartmentDto.class);

        String token = jwtService.generateToken(savedStudent.getEmail());

        StudentDto savedStudentData = modelMapper.map(savedStudent, StudentDto.class);

        savedStudentData.setDepartmentDto(departmentDto);

        return new StudentDto2(savedStudentData, token);
    }

    private List<AddressEntity> setStudentAddress(StudentDto studentDto, Student savedStudent) {
        List<AddressEntity> list = new ArrayList<>();

        List<AddressDto> addresses = studentDto.getAddresses();

        if (addresses != null && !addresses.isEmpty()) {
            for (AddressDto addressDto : addresses) {
                AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
                addressEntity.setStudent(savedStudent);
                list.add(addressEntity);
            }
        }
        return list;
    }

    private List<Mobile> setStudentMobiles(StudentDto studentDto, Student savedStudent) {

        System.out.println("studentDto"+studentDto);
        List<Mobile> list = new ArrayList<>();
        List<MobileDto> mobiles = studentDto.getMobiles();
        System.out.println(mobiles);
        if (mobiles != null && !mobiles.isEmpty()) {
            for (MobileDto mobileDto : mobiles) {
                Mobile mobileEntity = modelMapper.map(mobileDto, Mobile.class);
                mobileEntity.setStudent(savedStudent);
                list.add(mobileEntity);
            }
        }
        return list;
    }


    @Override
    public StudentDto findById(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return modelMapper.map(student, StudentDto.class);
        }
        else {
            throw new ResourceNotFoundException("Resource of id "+id+" is Not Found");
        }
    }

    @Override
    public StudentDto findByEmail(String email) {
        Student student = studentRepo.findByEmail(email);
        return modelMapper.map(student, StudentDto.class);
    }


//    @Override
//    public List<StudentDto> findByKeyword(String keyword) {
//        return List.of();
//    }

//    @Override
//    public StudentDto findByStudentDepartment(long studentId) {
//        Optional<Student> student= studentRepo.findById(studentId);
//        if(student.isPresent()){
//            Student studentDto = student.get();
//            return modelMapper.map(studentDto,StudentDto.class);
//        }
//
//        return null;
//    }

//    @Override
//    public StudentDto findByCourse(long id) {
//        return null;
//    }
//
//    @Override
//    public StudentDto findByMobile(String mobile) {
//        return null;
//    }

    @Override
    @Transactional
    public String deleteById(Long id) {

//        Optional<Mobile> byId = mobileRepo.findById(id);
//        if(byId.isPresent()){
//            Mobile mobile = byId.get();
//            mobileRepo.deleteById(mobile.getId());
//        }
//        Optional<AddressEntity> byId1 = addressRepo.findById(id);
//        if(byId1.isPresent()){
//            AddressEntity addressEntity = byId1.get();
//            addressRepo.deleteById(addressEntity.getAddressId());
//        }

        addressRepo.deleteByStudentId(id);
        mobileRepo.deleteByStudentId(id);
        studentRepo.deleteByStudentId(id);

        return "";
    }


    @Override
    public StudentDto showProfile(Long id) {
        Optional<Student> byId = studentRepo.findById(id);
        Student map = modelMapper.map(byId, Student.class);
        return modelMapper.map(map, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllData() {
        List<Student> allStudents = studentRepo.findAll();
        List<StudentDto> studentDtos = allStudents.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        return studentDtos;
    }


    public StudentDto updateStudent(StudentDto studentDto, Long id) {
        Optional<Student> byId = studentRepo.findById(id);
        if (byId.isPresent()) {
            Student student = byId.get();
            StudentDto map = modelMapper.map(student, StudentDto.class);
            return map;
        }
        return null;
    }
}
