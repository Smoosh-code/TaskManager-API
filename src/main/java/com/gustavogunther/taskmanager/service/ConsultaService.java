package com.gustavogunther.taskmanager.service;

import com.gustavogunther.taskmanager.model.Consulta;
import com.gustavogunther.taskmanager.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta save(Consulta c) {
        return consultaRepository.save(c);
    }

    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    //  Implementa correctamente el método para buscar por usuario
    public List<Consulta> findByUsuarioId(Long usuarioId) {
        return consultaRepository.findByUsuarioId(usuarioId);
    }
}
