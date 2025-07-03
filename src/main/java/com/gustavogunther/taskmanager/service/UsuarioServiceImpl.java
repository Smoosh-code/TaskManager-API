package com.gustavogunther.taskmanager.service;

import com.gustavogunther.taskmanager.model.Usuario;
import com.gustavogunther.taskmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        // aquí va la lógica de creación; por ahora delego a JPA
        return repo.save(usuario);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
