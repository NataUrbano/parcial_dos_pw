package com.example.demo.Repository;

import com.example.demo.Entity.AsignaturasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AsignaturasRepository extends JpaRepository<AsignaturasEntity, Integer> {
    List<AsignaturasEntity> findByDocentesEntityId(Long docenteId);
}

