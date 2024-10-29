package com.example.demo.Service;

import com.example.demo.Entity.AsignaturasEntity;
import com.example.demo.Repository.AsignaturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service

public class AsignaturasService {
    @Autowired
    private AsignaturasRepository asignaturasRepository;

    public List<AsignaturasEntity> obtenerTodasLasAsignaturas() {
        return asignaturasRepository.findAll();
    }

    public AsignaturasEntity crearAsignatura(AsignaturasEntity asignatura) {
        return asignaturasRepository.save(asignatura);
    }

    public AsignaturasEntity actualizarAsignatura(Long id, AsignaturasEntity asignaturaActualizada) {
        Optional<AsignaturasEntity> asignaturaExistente = asignaturasRepository.findById(id);
        if (asignaturaExistente.isPresent()) {
            asignaturaActualizada.setId(id);
            return asignaturasRepository.save(asignaturaActualizada);
        }
        return null;
    }

    public void eliminarAsignatura(Integer id) {
        asignaturasRepository.deleteById(id);
    }

    public List<AsignaturasEntity> obtenerAsignaturasPorDocente(Long docenteId) {
        return asignaturasRepository.findByDocentesEntityId(docenteId);
    }

    public AsignaturasEntity actualizarHorarioAsignatura(Long id, LocalTime horaInicio, LocalTime horaFin) {
        AsignaturasEntity asignatura = asignaturasRepository.findById(id).orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
        asignatura.setHoraInicio(horaInicio);
        asignatura.setHoraFin(horaFin);
        return asignaturasRepository.save(asignatura);
    }
}
