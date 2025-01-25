package com.gaos.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AddressDTO {
    private Long id;

    @NotBlank(message = "The STREET field is required.")
    @Size(min = 2,max = 100, message = "The STREET field must be between 2 and 100 characters.")
    private String street;

    @NotBlank(message = "The NEIGHBORHOOD field is required.")
    @Size(min=  2, max = 100, message = "The NEIGHBORHOOD field must be between 2 and 100 characters.")
    private String neighborhood;

    @NotBlank(message = "The CITY field is required.")
    @Size(min=  2, max = 100, message = "The CITY field must be between 2 and 100 characters.")
    private String city;

    @NotBlank(message = "The STATE field is required.")
    @Size(min = 2, max = 2, message = "The STATE field must be 2 characters.")
    private String state;

    @NotBlank(message = "The CEP field is required.")
    @Size(min = 8, max = 8, message = "The CEP field must be 8 digits.")
    @Pattern(
            regexp = "^[0-9]{8}$",
            message = "The CPF field must be 8 numeric digits"
    )
    private String cep;

    private String complement;

    // Construtor com todos os argumentos
    public AddressDTO(Long id, String street, String neighborhood, String city, String state, String cep, String complement) {
        this.id = id;
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.complement = complement;
    }

    // Construtor padrão
    public AddressDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
