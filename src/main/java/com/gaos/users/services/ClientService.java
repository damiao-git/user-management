package com.gaos.users.services;

import com.gaos.users.dto.ClientDTO;
import com.gaos.users.entities.Address;
import com.gaos.users.entities.Client;
import com.gaos.users.entities.Email;
import com.gaos.users.entities.Phone;
import com.gaos.users.repositories.AddressRepository;
import com.gaos.users.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    AddressRepository addressRepository;
    public List<Client> listAll(){
        return repository.findAll();
    }

    public Optional<Client> findById(Long id){
        return repository.findById(id);
    }

    public Client convertToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());

        Address address = new Address();
        address.setCep(clientDTO.getAddress().getCep());
        address.setStreet(clientDTO.getAddress().getStreet());
        address.setNeighborhood(clientDTO.getAddress().getNeighborhood());
        address.setCity(clientDTO.getAddress().getCity());
        address.setState(clientDTO.getAddress().getState());
        address.setComplement(clientDTO.getAddress().getComplement());
        client.setAddress(address);

        List<Phone> phones = clientDTO.getPhones().stream().map(phoneDTO -> {
            Phone phone = new Phone();
            phone.setNumber(phoneDTO.getNumber());
            phone.setType(phoneDTO.getType());
            phone.setClient(client);
            return phone;
        }).toList();
        client.setPhones(phones);

        List<Email> emails = clientDTO.getEmails().stream().map(emailDTO -> {
            Email email = new Email();
            email.setEmail(emailDTO.getEmail());
            email.setClient(client);
            return email;
        }).toList();
        client.setEmails(emails);

        return client;
    }

    @Transactional
    public Client save(Client client){

        return repository.save(client);
    }

    public Client update(Long id, ClientDTO clientDTO) {
        return repository.findById(id).map(client -> {
            client.setName(clientDTO.getName());
            client.setCpf(clientDTO.getCpf());

            if (clientDTO.getAddress() != null) {
                Address updatedAddress = client.getAddress() != null ? client.getAddress() : new Address();
                updatedAddress.setCep(clientDTO.getAddress().getCep());
                updatedAddress.setStreet(clientDTO.getAddress().getStreet());
                updatedAddress.setNeighborhood(clientDTO.getAddress().getNeighborhood());
                updatedAddress.setCity(clientDTO.getAddress().getCity());
                updatedAddress.setState(clientDTO.getAddress().getState());
                updatedAddress.setComplement(clientDTO.getAddress().getComplement());
                client.setAddress(updatedAddress);
            }

            if (clientDTO.getPhones() != null) {
                client.getPhones().clear();
                clientDTO.getPhones().forEach(phoneDTO -> {
                    Phone phone = new Phone();
                    phone.setNumber(phoneDTO.getNumber());
                    phone.setType(phoneDTO.getType());
                    phone.setClient(client);
                    client.getPhones().add(phone);
                });
            }

            if (clientDTO.getEmails() != null) {
                client.getEmails().clear();
                clientDTO.getEmails().forEach(emailDTO -> {
                    Email email = new Email();
                    email.setEmail(emailDTO.getEmail());
                    email.setClient(client);
                    client.getEmails().add(email);
                });
            }

            return repository.save(client);
        }).orElse(null);
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
