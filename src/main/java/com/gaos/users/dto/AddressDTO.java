package com.gaos.users.dto;

public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String cep;

    // Construtor com todos os argumentos
    public AddressDTO(Long id, String street, String city, String state, String cep) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    // Construtor padrão
    public AddressDTO() {
    }

    // Getters e Setters
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

    public void setCep(String zipCode) {
        this.cep = zipCode;
    }
}
