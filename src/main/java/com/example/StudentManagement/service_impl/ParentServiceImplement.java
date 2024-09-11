package com.example.StudentManagement.service_impl;

import com.example.StudentManagement.dto.ParentDto;
import com.example.StudentManagement.entities.Parent;
import com.example.StudentManagement.exceptions.ResourceNotFoundException;
import com.example.StudentManagement.repo.ParentRepo;
import com.example.StudentManagement.services.ParentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ParentServiceImplement implements ParentService {

    @Autowired
    private ParentRepo parentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ParentDto addParent(ParentDto parentDto) {
        Parent map = modelMapper.map(parentDto, Parent.class);
        Parent save = parentRepo.save(map);
        return modelMapper.map(save,ParentDto.class);
    }

    @Override
    public ParentDto getById(Long id) {
        Optional<Parent> byId = parentRepo.findById(id);
        if(byId.isPresent()){
            Parent parent = byId.get();
            ParentDto parentDto = modelMapper.map(parent, ParentDto.class);
            return parentDto;
        }
        else {
            throw new ResourceNotFoundException("Not Found Parent By Id");
        }
    }

    @Override
    public List<ParentDto> getAllParents() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
