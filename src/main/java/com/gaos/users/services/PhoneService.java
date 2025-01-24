package com.gaos.users.services;

import com.gaos.users.entities.Address;
import com.gaos.users.entities.Phone;
import com.gaos.users.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;


    public List<Phone> listAll(){
        return repository.findAll();
    }

    public Optional<Phone> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Phone save(Phone phone){
        return repository.save(phone);
    }

    @Transactional
    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new RuntimeException("Id " + id + " not found!");
        }
    }
}
