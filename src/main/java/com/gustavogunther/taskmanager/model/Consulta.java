package com.gustavogunther.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pregunta;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String prioridad;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // === NUEVO: Campo respuesta ===
    @Column(columnDefinition = "TEXT")
    private String respuesta;

    /* Constructores */

    protected Consulta() {
    }

    public Consulta(String pregunta, Usuario usuario, String categoria, String estado, String prioridad, String respuesta) {
        this.pregunta = pregunta;
        this.usuario = usuario;
        this.categoria = categoria;
        this.estado = estado;
        this.prioridad = prioridad;
        this.respuesta = respuesta;
        this.fechaCreacion = LocalDateTime.now();
    }

    public Consulta(String pregunta, Usuario usuario, String categoria, String estado, String prioridad) {
        this(pregunta, usuario, categoria, estado, prioridad, null);
    }

    /* Getters & Setters */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPregunta() { return pregunta; }
    public void setPregunta(String pregunta) { this.pregunta = pregunta; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getRespuesta() { return respuesta; }
    public void setRespuesta(String respuesta) { this.respuesta = respuesta; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consulta consulta)) return false;
        return id != null && id.equals(consulta.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
