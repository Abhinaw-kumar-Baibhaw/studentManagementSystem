package com.example.StudentManagement.controllers;


import com.example.StudentManagement.dto.ProfileDto;
import com.example.StudentManagement.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/add")
    public ProfileDto add(@RequestBody ProfileDto profileDto){
        return profileService.addProfile(profileDto);
    }

    @GetMapping("/{id}")
    public ProfileDto findById(Long id){
        return profileService.findById(id);
    }
}
