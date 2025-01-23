package com.gaos.users.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "The cpf field is required")
    private String cep;
    @NotBlank(message = "The street field is required")
    private String street;
    @NotBlank(message = "The neighborhood field is required")
    private String neighborhood;
    @NotBlank(message = "The city is required")
    private String city;
    @NotBlank(message = "The state field is required")
    private String state;
    private String complement;

}
