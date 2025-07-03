package com.gustavogunther.taskmanager.service;

import com.gustavogunther.taskmanager.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario create(Usuario usuario);    // <<< aquí
    Usuario save(Usuario usuario);      // para update
    boolean existsById(Long id);
    void deleteById(Long id);
}
