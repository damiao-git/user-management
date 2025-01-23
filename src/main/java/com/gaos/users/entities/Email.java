package com.gaos.users.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The address email is required!")
    @jakarta.validation.constraints.Email(message = "Invalid e-mail")
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
