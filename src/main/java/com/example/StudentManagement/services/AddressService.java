package com.example.StudentManagement.services;

import com.example.StudentManagement.dto.AddressDto;
import com.example.StudentManagement.entities.AddressEntity;

import java.util.List;

public interface AddressService {

    public AddressDto findById(Long id);


    public AddressDto addAddress(AddressDto address);


    public void delete(Long id);


    public List<AddressEntity> findAll();


}
