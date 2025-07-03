
package com.gustavogunther.taskmanager.controller;

import com.gustavogunther.taskmanager.model.Consulta;
import com.gustavogunther.taskmanager.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Consulta> getConsultaById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Consulta> getConsultasByUsuario(@PathVariable Long usuarioId) {
        return consultaService.findByUsuarioId(usuarioId);
    }

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsulta(@PathVariable Long id) {
        consultaService.deleteById(id);
    }

    // ==== CORREGIDO: Ahora actualiza todos los campos relevantes ====
    @PutMapping("/{id}")
    public Consulta updateConsulta(@PathVariable Long id, @RequestBody Consulta consultaActualizada) {
        return consultaService.findById(id)
                .map(consultaExistente -> {
                    consultaExistente.setPregunta(consultaActualizada.getPregunta());
                    consultaExistente.setCategoria(consultaActualizada.getCategoria());
                    consultaExistente.setEstado(consultaActualizada.getEstado());
                    consultaExistente.setPrioridad(consultaActualizada.getPrioridad());
                    consultaExistente.setUsuario(consultaActualizada.getUsuario());
                    consultaExistente.setRespuesta(consultaActualizada.getRespuesta());

                    // No se debería modificar fechaCreacion, ni id

                   

                    return consultaService.save(consultaExistente);
                })
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada con id: " + id));
    }
}

