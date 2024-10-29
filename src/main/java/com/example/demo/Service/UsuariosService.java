package com.example.demo.Service;

import com.example.demo.Entity.UsuariosEntity;
import com.example.demo.Repository.UsuariosRepository;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuariosService {

    @Autowired
    private UsuariosRepository UsuariosRepository;

    public List<UsuariosEntity> obtenerTodosLosUsuarios() {
        return UsuariosRepository.findAll();
    }

    public java.util.Optional<UsuariosEntity> obtenerUsuarioPorId(Integer id) {
        return UsuariosRepository.findById(id);
    }

    public UsuariosEntity crearUsuario(UsuariosEntity usuario) {
        return UsuariosRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        UsuariosRepository.deleteById(id);
    }
}
