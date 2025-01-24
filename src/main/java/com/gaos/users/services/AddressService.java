package com.gaos.users.services;

import com.gaos.users.entities.Address;
import com.gaos.users.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> listAll(){
        return repository.findAll();
    }

    public Optional<Address> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Address save(Address address){
        return repository.save(address);
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
