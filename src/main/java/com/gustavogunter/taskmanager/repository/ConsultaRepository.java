package com.gustavogunter.taskmanager.repository;

import com.gustavogunter.taskmanager.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByUsuarioId(Long usuarioId);
}
