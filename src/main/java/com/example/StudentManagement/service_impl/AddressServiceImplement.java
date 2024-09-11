package com.example.StudentManagement.service_impl;
import com.example.StudentManagement.dto.AddressDto;
import com.example.StudentManagement.entities.AddressEntity;
import com.example.StudentManagement.repo.AddressRepo;
import com.example.StudentManagement.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AddressServiceImplement implements AddressService {

    @Autowired
    private AddressRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDto findById(Long id){
        Optional<AddressEntity> byId = repo.findById(id);
        if(byId.isPresent()){
            AddressEntity map = modelMapper.map(byId, AddressEntity.class);
            return modelMapper.map(map,AddressDto.class);
        }
        else{
            throw new RuntimeException("Employee Not Found By Id");
        }
    }

    @Override
    public AddressDto addAddress(AddressDto address) {
        AddressEntity map = modelMapper.map(address, AddressEntity.class);
        AddressEntity save = repo.save(map);
        return modelMapper.map(save,AddressDto.class);
    }

    @Override
    public void delete(Long id) {
//        Optional<AddressEntity> byId = repo.findById(id);
//        if(byId.isPresent()){
//            AddressEntity map = modelMapper.map(byId, AddressEntity.class);
//            repo.delete(map);
//        }
    }

    @Override
    public List<AddressEntity> findAll() {
        return List.of();
    }
}
