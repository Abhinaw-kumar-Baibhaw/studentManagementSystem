package com.example.StudentManagement.controllers;

import com.example.StudentManagement.dto.MobileDto;
import com.example.StudentManagement.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    private final MobileService mobileService;

    @Autowired
    public MobileController(MobileService mobileService){

        this.mobileService = mobileService;
    }

    @GetMapping("/findById")
    public MobileDto getMobileById(@RequestParam Long mobileId){
        return mobileService.getMobileById(mobileId);
    }

    @PostMapping("add")
    public MobileDto addMobile(@RequestBody MobileDto mobile){
        return mobileService.addMobile(mobile);
    }
}
