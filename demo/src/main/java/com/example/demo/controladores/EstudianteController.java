package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Estudiante;
import com.example.demo.servicios.EstudianteService;

@RestController
@RequestMapping("/api")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Endpoint para actualizar el conteo
    @GetMapping("/actualizar-conteo")
    public ResponseEntity<String> actualizarConteo() {
        estudianteService.actualizarConteo();
        return ResponseEntity.ok("Conteo actualizado correctamente.");
    }

    // Endpoint para obtener el total de estudiantes actualizados
    @GetMapping("/total-actualizados")
    public ResponseEntity<Long> obtenerTotalActualizados() {
        long total = estudianteService.obtenerTotalActualizados();
        return ResponseEntity.ok(total);
    }

    // Endpoint para agregar un nuevo estudiante
    @PostMapping("/estudiantes")
    public ResponseEntity<Estudiante> agregarEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantes() {
    List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
    return ResponseEntity.ok(estudiantes);
}
}
