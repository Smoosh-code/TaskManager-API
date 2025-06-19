package com.gustavogunter.taskmanager.controller;

import com.gustavogunter.taskmanager.model.Consulta;
import com.gustavogunter.taskmanager.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Obtener todas las consultas
    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.findAll();
    }

    // Obtener consulta por ID
    @GetMapping("/{id}")
    public Optional<Consulta> getConsultaById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    // Obtener todas las consultas de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Consulta> getConsultasByUsuario(@PathVariable Long usuarioId) {
        return consultaService.findByUsuarioId(usuarioId);
    }

    // Crear una nueva consulta
    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    // Eliminar consulta por ID
    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable Long id) {
        consultaService.deleteById(id);
    }
    // Actualizar una consulta existente
    @PutMapping("/{id}")
    public Consulta updateConsulta(@PathVariable Long id, @RequestBody Consulta consultaActualizada) {
        return consultaService.findById(id)
                .map(consultaExistente -> {
                    consultaExistente.setPregunta(consultaActualizada.getPregunta());
                    consultaExistente.setRespuesta(consultaActualizada.getRespuesta());
                    // (opcional) actualizar fechaCreacion o usuario si querés permitirlo
                    return consultaService.save(consultaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada con id: " + id));
    }

}
