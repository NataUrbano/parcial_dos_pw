package com.example.demo.Controller;

import com.example.demo.Entity.AsignaturasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class DocenteController {
    @Autowired
    private AsignaturasService asignaturasService;

    @GetMapping
    @PreAuthorize("hasRole('DOCENTE')")
    public List<AsignaturasEntity> obtenerAsignaturasPorDocente(@RequestParam Long docenteId) {
        return asignaturasService.obtenerAsignaturasPorDocente(docenteId);
    }

    @PutMapping("/actualizarHorario/{id}")
    @PreAuthorize("hasRole('DOCENTE')")
    public ResponseEntity<AsignaturasEntity> actualizarHorarioAsignatura(
            @PathVariable Long id,
            @RequestBody AsignaturasEntity asignatura) {
        AsignaturasEntity asignaturaActualizada = asignaturasService.actualizarHorarioAsignatura(id, asignatura.getHoraInicio(), asignatura.getHoraFin());
        return ResponseEntity.ok(asignaturaActualizada);
    }
}
