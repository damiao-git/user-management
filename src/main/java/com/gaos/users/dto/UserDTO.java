package com.gaos.users.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private List<PhoneDTO> phones;
    private List<EmailDTO> emails;
    private AddressDTO address;

    // Construtor com todos os argumentos
    public UserDTO(Long id, String name, List<PhoneDTO> phones, List<EmailDTO> emails) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.emails = emails;
    }

    // Construtor padrão
    public UserDTO() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public List<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDTO> emails) {
        this.emails = emails;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
