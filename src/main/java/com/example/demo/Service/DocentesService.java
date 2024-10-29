package com.example.demo.Service;

import com.example.demo.Entity.DocentesEntity;
import com.example.demo.Repository.DocentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocentesService {
    @Autowired
    private DocentesRepository docentesRepository;

    public List<DocentesEntity> obtenerTodosLosDocentes() {
        return docentesRepository.findAll();
    }

    public Optional<DocentesEntity> obtenerDocentePorId(Integer id) {
        return docentesRepository.findById(id);
    }

    public DocentesEntity crearDocente(DocentesEntity docente) {
        return docentesRepository.save(docente);
    }

    public DocentesEntity actualizarDocente(Integer id, DocentesEntity docenteActualizado) {
        Optional<DocentesEntity> docenteExistente = docentesRepository.findById(id);
        if (docenteExistente.isPresent()) {
            docenteActualizado.setId(Long.valueOf(id));
            return docentesRepository.save(docenteActualizado);
        }
        return null;
    }

    public void eliminarDocente(Integer id) {
        docentesRepository.deleteById(id);
    }
}
