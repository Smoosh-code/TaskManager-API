package com.gustavogunther.taskmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavogunther.taskmanager.model.Usuario;
import com.gustavogunther.taskmanager.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc(addFilters = false)          // desactiva los filtros de Spring Security
class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper mapper;

    /* ------------------------------------------------------------------
     * GET /api/usuarios  – lista vacía
     * ------------------------------------------------------------------ */
    @Test
    @DisplayName("GET /api/usuarios → lista vacía")
    void whenNoUsuarios_thenReturnEmptyArray() throws Exception {
        Mockito.when(usuarioService.findAll()).thenReturn(Arrays.asList());

        mvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    /* ------------------------------------------------------------------
     * GET /api/usuarios  – lista con un elemento
     * ------------------------------------------------------------------ */
    @Test
    @DisplayName("GET /api/usuarios → devuelve lista con un usuario")
    void whenUsuariosExist_thenReturnJsonArray() throws Exception {
        Usuario u = new Usuario();
        u.setId(1L);
        u.setNombre("juan");
        u.setEmail("juan@mail.com");
        u.setRol("consultante");
        u.setEspecialidad("Cardiologo");

        Mockito.when(usuarioService.findAll()).thenReturn(Arrays.asList(u));

        mvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("juan")));
    }

    /* ------------------------------------------------------------------
     * GET /api/usuarios/{id}  – encontrado
     * ------------------------------------------------------------------ */
    @Test
    @DisplayName("GET /api/usuarios/{id} → encontrado")
    void whenGetUsuarioById_thenReturnUsuario() throws Exception {
        Usuario u = new Usuario();
        u.setId(42L);
        u.setNombre("ana");
        u.setEmail("ana@mail.com");
        u.setRol("especialista");
        u.setEspecialidad("Abogado");

        Mockito.when(usuarioService.findById(42L)).thenReturn(Optional.of(u));

        mvc.perform(get("/api/usuarios/42"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is("ana")));
    }

    /* ------------------------------------------------------------------
     * GET /api/usuarios/{id}  – no encontrado
     * ------------------------------------------------------------------ */
    @Test
    @DisplayName("GET /api/usuarios/{id} → no encontrado")
    void whenGetUsuarioNotFound_then404() throws Exception {
        Mockito.when(usuarioService.findById(99L)).thenReturn(Optional.empty());

        mvc.perform(get("/api/usuarios/99"))
                .andExpect(status().isNotFound());
    }

    /* ------------------------------------------------------------------
     * POST /api/usuarios  – crea usuario
     * ------------------------------------------------------------------ */
    @Test
    @DisplayName("POST /api/usuarios → crea usuario")
    void whenPostUsuario_thenCreate() throws Exception {
        // Objeto que enviamos (sin id)
        Usuario toCreate = new Usuario();
        toCreate.setNombre("pepe");
        toCreate.setEmail("pepe@mail.com");
        toCreate.setRol("consultante");
        toCreate.setEspecialidad("Cardiologo");

        // Stub: cualquier Usuario que reciba será devuelto con id 100
        Mockito.when(usuarioService.create(Mockito.any(Usuario.class)))
                .thenAnswer(inv -> {
                    Usuario u = inv.getArgument(0, Usuario.class);
                    u.setId(100L);            // fuerza la ID para Location
                    return u;
                });

        mvc.perform(post("/api/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(toCreate)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/api/usuarios/100")))
                .andExpect(jsonPath("$.id", is(100)))
                .andExpect(jsonPath("$.nombre", is("pepe")));
    }
}
