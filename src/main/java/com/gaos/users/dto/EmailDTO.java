package com.gaos.users.dto;

import com.gaos.users.entities.Client;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {
    private Long id;
    @NotBlank(message = "The address email is required!")
    @jakarta.validation.constraints.Email(message = "Invalid e-mail")
    private String email;
    private ClientDTO client;

    public EmailDTO() {
    }

    public EmailDTO(Long id, String email, ClientDTO client) {
        this.id = id;
        this.email = email;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
