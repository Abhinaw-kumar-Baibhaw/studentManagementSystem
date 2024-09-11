package com.example.StudentManagement.controllers;

import com.example.StudentManagement.dto.AddressDto;
import com.example.StudentManagement.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public AddressDto addAddress(@RequestBody AddressDto address) {
      return addressService.addAddress(address);
    }

    @GetMapping("/delete/{id}")
    public void delete(Long id){
        addressService.delete(id);
    }
}
