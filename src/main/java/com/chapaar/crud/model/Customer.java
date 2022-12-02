package com.chapaar.crud.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "First Name is required")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]{1,100}$", message ="First Name should have 1 to 100 characters")
    @Column(name = "first_name", length = 100)
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]{1,100}$", message ="Last Name should have 1 to 100 characters")
    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "description", length = 500)
    private String description;
}
