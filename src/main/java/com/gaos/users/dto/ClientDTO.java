package com.gaos.users.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ClientDTO {
    private Long id;

    @NotBlank(message = "The name field is required.")
    @Size(min = 3, max = 100, message = "The name field must be between 3 and 100 characters")
    @Pattern(
            regexp = "^[a-zA-Z0-9 ]+$",
            message = "The name field accept only, letters, numbers and empty spaces"
    )
    private String name;

    @NotBlank(message = "The cpf field is required.")
    @Pattern(
            regexp = "^[0-9]{11}$",
            message = "The CPF field must be 11 numeric digits"
    )
    private String cpf;

    @Valid
    @NotEmpty(message = "Must be minimum 1 phone number.")
    private List<PhoneDTO> phones;

    @Valid
    @NotEmpty(message = "Must be minimum 1 email.")
    private List<EmailDTO> emails;

    @Valid

    private AddressDTO address;

    public ClientDTO(Long id, String name, String cpf, List<PhoneDTO> phones, List<EmailDTO> emails) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phones = phones;
        this.emails = emails;
    }

    public ClientDTO() {
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
