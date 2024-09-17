package com.example.StudentManagement.controllers;

import com.example.StudentManagement.dto.ParentDto;
import com.example.StudentManagement.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping("/add")
    public ParentDto addParent(@RequestBody ParentDto parentDto){
        return parentService.addParent(parentDto);
    }

    @GetMapping("/{id}")
    public ParentDto getById(@PathVariable Long id){
        return parentService.getById(id);
    }

    @DeleteMapping("/{deleteById}")
    public void deleteById(@PathVariable Long deleteById){
        parentService.deleteById(deleteById);
    }

}
