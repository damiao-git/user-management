package com.gaos.users.services;

import com.gaos.users.entities.Email;
import com.gaos.users.repositories.EmailRepository;
import com.gaos.users.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    private EmailRepository repository;


    public List<Email> listAll(){
        return repository.findAll();
    }

    public Optional<Email> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Email save(Email email){
        return repository.save(email);
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
