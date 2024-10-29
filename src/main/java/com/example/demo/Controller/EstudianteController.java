package com.example.demo.Controller;

import com.example.demo.Entity.AsignaturasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class EstudianteController {
    @Autowired
    private AsignaturasService asignaturasService;

    @GetMapping
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public List<AsignaturasEntity> verAsignaturas() {
        return asignaturasService.obtenerTodasLasAsignaturas();
    }
}
