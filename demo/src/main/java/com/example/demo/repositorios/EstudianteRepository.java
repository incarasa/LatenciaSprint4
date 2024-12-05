package com.example.demo.repositorios;

import java.util.List;

import com.example.demo.entidades.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByActualizadoTrue();
}

