package com.gustavogunter.taskmanager.repository;

import com.gustavogunter.taskmanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Acá podés agregar métodos personalizados si querés buscar por email, etc.
    Usuario findByEmail(String email);
}
