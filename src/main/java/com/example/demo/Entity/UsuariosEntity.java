package com.example.demo.Entity;

import jakarta.persistence.*;

public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 100)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolesEntity rolesEntity;
}
