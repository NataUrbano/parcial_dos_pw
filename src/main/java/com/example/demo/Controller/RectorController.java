package com.example.demo.Controller;

import com.example.demo.Entity.AsignaturasEntity;
import com.example.demo.Repository.AsignaturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rector/asignaturas")

public class RectorController {
    @Autowired
    private AsignaturasService asignaturasService;

    @GetMapping
    @PreAuthorize("hasRole('RECTOR')")
    public List<AsignaturasEntity> obtenerTodasLasAsignaturas() {
        return asignaturasService.obtenerTodasLasAsignaturas();
    }

    @PostMapping("/crear")
    @PreAuthorize("hasRole('RECTOR')")
    public ResponseEntity<AsignaturasEntity> crearAsignatura(@RequestBody AsignaturasEntity asignatura) {
        AsignaturasEntity nuevaAsignatura = asignaturasService.crearAsignatura(asignatura);
        return ResponseEntity.ok(nuevaAsignatura);
    }

    @PutMapping("/editar/{id}")
    @PreAuthorize("hasRole('RECTOR')")
    public ResponseEntity<AsignaturasEntity> editarAsignatura(@PathVariable Long id, @RequestBody AsignaturasEntity asignatura) {
        AsignaturasEntity asignaturaActualizada = asignaturasService.actualizarAsignatura(id, asignatura);
        return ResponseEntity.ok(asignaturaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('RECTOR')")
    public ResponseEntity<String> eliminarAsignatura(@PathVariable Long id) {
        asignaturasService.eliminarAsignatura(id);
        return ResponseEntity.ok("Asignatura eliminada correctamente");
    }
}
