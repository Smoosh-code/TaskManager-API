package com.gustavogunter.taskmanager.service;


import com.gustavogunter.taskmanager.model.Usuario;
import com.gustavogunter.taskmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Buscar todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por ID
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar usuario
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario por ID
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Buscar usuario por email
    public Optional<Usuario> findByEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }
}
