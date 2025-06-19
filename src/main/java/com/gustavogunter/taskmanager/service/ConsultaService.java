package com.gustavogunter.taskmanager.service;
import com.gustavogunter.taskmanager.repository.ConsultaRepository;
import com.gustavogunter.taskmanager.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    // Listar todas las consultas
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    // Buscar consulta por id
    public Optional<Consulta> findById(Long id) {
        return consultaRepository.findById(id);
    }

    // Crear o actualizar consulta
    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // Eliminar consulta por id
    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    // Buscar todas las consultas de un usuario
    public List<Consulta> findByUsuarioId(Long usuarioId) {
        return consultaRepository.findByUsuarioId(usuarioId);
    }
}
