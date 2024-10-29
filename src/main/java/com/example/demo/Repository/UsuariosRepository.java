package com.example.demo.Repository;

import com.example.demo.Entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
    Optional<UsuariosEntity> findByCorreo(String correo);
}
