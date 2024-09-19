package com.example.StudentManagement.controllers;
import com.example.StudentManagement.config.JwtService;
import com.example.StudentManagement.entities.Student;
import com.example.StudentManagement.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Auth")
public class LoginController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager, StudentRepo studentRepo) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.studentRepo = studentRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(student.getEmail(), student.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.generateToken(student.getEmail());
        return ResponseEntity.ok(token);
    }
}
