package com.example.filmets.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users", schema = "filmets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "Email")
    private String email;

}
