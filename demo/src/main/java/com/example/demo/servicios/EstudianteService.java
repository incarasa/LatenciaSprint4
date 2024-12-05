package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Contador;
import com.example.demo.entidades.Estudiante;
import com.example.demo.repositorios.ContadorRepository;
import com.example.demo.repositorios.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ContadorRepository contadorRepository;

    public void actualizarConteo() {
        // Obtener estudiantes actualizados
        List<Estudiante> actualizados = estudianteRepository.findByActualizadoTrue();
        long totalActualizados = actualizados.size();

        // Crear o actualizar el contador en MongoDB
        Contador contador = contadorRepository.findById("1").orElse(new Contador());
        contador.setId("1");
        contador.setTotalActualizados(totalActualizados);
        contadorRepository.save(contador);
    }

    public long obtenerTotalActualizados() {
        Contador contador = contadorRepository.findById("1").orElse(new Contador());
        return contador.getTotalActualizados();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

}
