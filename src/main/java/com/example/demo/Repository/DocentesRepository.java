package com.example.demo.Repository;

import com.example.demo.Entity.DocentesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DocentesRepository extends JpaRepository<DocentesEntity, Integer> {
    DocentesEntity findByNombre(String nombre);
}
