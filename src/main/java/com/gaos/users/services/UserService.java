package com.gaos.users.services;

import com.gaos.users.entities.Address;
import com.gaos.users.entities.Email;
import com.gaos.users.entities.Phone;
import com.gaos.users.entities.User;
import com.gaos.users.repositories.AddressRepository;
import com.gaos.users.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    AddressRepository addressRepository;
    public List<User> listAll(){
        return repository.findAll();
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public User save(User user){
        return repository.save(user);
    }

    public User update(Long id, User user) {
        Optional<User> userExist = repository.findById(id);

        if (userExist.isPresent()) {
            User newUser = userExist.get();

            // Copiar propriedades simples
            BeanUtils.copyProperties(user, newUser);

            // Atualizar objetos complexos (como Address, Phones, Emails)
            Address address = user.getAddress();
            if (address != null) {
                if (address.getId() != null) {
                    // Se o ID do Address já existir, buscar o Address
                    Address existingAddress = addressRepository.findById(address.getId())
                            .orElseThrow(() -> new RuntimeException("Address not found with ID " + address.getId()));
                    newUser.setAddress(existingAddress);
                } else {
                    // Caso o endereço seja novo, salvar no banco
                    Address savedAddress = addressRepository.save(address);
                    newUser.setAddress(savedAddress);
                }
            }

            List<Phone> phones = user.getPhones();
            if (phones != null) {
                // Atribuindo a lista de Phones diretamente (pode adicionar lógica para salvar novos phones, se necessário)
                newUser.setPhones(phones);
            }

            List<Email> emails = user.getEmails();
            if (emails != null) {
                // Atribuindo a lista de Emails diretamente (pode adicionar lógica para salvar novos emails, se necessário)
                newUser.setEmails(emails);
            }

            // Salvar o novo objeto User com as modificações
            return repository.save(newUser);
        } else {
            throw new RuntimeException("User with ID " + id + " not found.");
        }
    }


    @Transactional
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " not found.");
        }
    }

}
