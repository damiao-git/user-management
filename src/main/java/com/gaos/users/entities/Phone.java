package com.gaos.users.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The type number is required")
    private String type;

    @NotBlank(message = "The number is required.")
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
