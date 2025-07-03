package com.gustavogunther.taskmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String rol;            // "especialista" o "consultante"

    @Column(nullable = false)
    private String especialidad;   // Ej: "Cardiologo", "Abogado", etc.

    @Column(nullable = false)
    private String estado = "activo";

    @CreationTimestamp
    @Column(name = "fecha_alta", nullable = false)
    private LocalDateTime fechaAlta;

    // --- Constructores ---
    public Usuario() {
        // fechaAlta la rellena Hibernate; no hace falta asignarla
        this.estado = "activo";
    }

    public Usuario(String nombre, String email, String rol, String especialidad) {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.especialidad = especialidad;
        this.estado = "activo";
        // fechaAlta se rellenará automáticamente
    }

    // Constructor usado en tests
    public Usuario(String nombre, String email, String rol) {
        this(nombre, email, rol, null);
    }

    // --- Getters & Setters ---


    public Long getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
