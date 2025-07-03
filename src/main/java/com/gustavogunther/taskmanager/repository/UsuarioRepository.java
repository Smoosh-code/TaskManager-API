package com.gustavogunther.taskmanager.repository;

import com.gustavogunther.taskmanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aca se podrian  agregar mtodos personalizados...
    Usuario findByEmail(String email);


}
