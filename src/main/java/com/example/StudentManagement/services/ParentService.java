package com.example.StudentManagement.services;

import com.example.StudentManagement.dto.ParentDto;

import java.util.List;

public interface ParentService {

    public ParentDto addParent(ParentDto parentDto);

    public List<ParentDto> getAllParents();

    public void deleteById(Long id);

    ParentDto getById(Long id);
}
