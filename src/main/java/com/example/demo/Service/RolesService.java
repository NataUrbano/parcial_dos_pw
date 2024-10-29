package com.example.demo.Service;

import com.example.demo.Entity.RolesEntity;
import com.example.demo.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RolesService {

    private RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public List<RolesEntity> obtenerTodosLosRoles() {
        return rolesRepository.findAll();
    }

    public Optional<RolesEntity> obtenerRolPorId(Integer id) {
        return rolesRepository.findById(id);
    }

    public RolesEntity crearRol(RolesEntity rol) {
        return rolesRepository.save(rol);
    }

    public RolesEntity actualizarRol(Integer id, RolesEntity rolActualizado) {
        Optional<RolesEntity> rolExistente = rolesRepository.findById(id);
        if (rolExistente.isPresent()) {
            rolActualizado.setId(Long.valueOf(id));
            return rolesRepository.save(rolActualizado);
        }
        return null;
    }

    public void eliminarRol(Integer id) {
        rolesRepository.deleteById(id);
    }
}

