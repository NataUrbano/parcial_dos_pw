package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name= "asignaturas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AsignaturasEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 30)
        private String nombre;

        @Column(length = 100)
        private String descripcion;

        @Column(nullable = false)
        private Integer salon;

        @Column(nullable = false)
        private LocalTime horaInicio;

        @Column(nullable = false)
        private LocalTime horaFin;

        @ManyToOne
        @JoinColumn(name = "docente_id")
        private DocentesEntity docentesEntity;
}