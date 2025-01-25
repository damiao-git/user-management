package com.gaos.users.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PhoneDTO {
    private Long id;

    @NotBlank(message = "The type number is required")
    @Pattern(regexp = "^(home|mobile|business)$", message = "Invalid Type. Must be 'home', 'mobile' or 'business'.")
    private String type;

    @NotBlank(message = "The number is required.")
    @Pattern(regexp = "^\\d{10}$|^\\d{11}$", message = "Phone number must be 10 digits with DDD or 11 digits for mobile.")
    private String number;

    private ClientDTO client;

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, String type, String number, ClientDTO client) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if(this.getType().equals("mobile")){
            if(!number.matches("^\\d{11}$")){
                throw new RuntimeException("Mobile need 11 digits");
            }
        }
        this.number = number;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}

