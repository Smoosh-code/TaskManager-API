package com.gustavogunther.taskmanager.service;

import com.gustavogunther.taskmanager.model.Consulta;
import com.gustavogunther.taskmanager.model.Usuario;
import com.gustavogunther.taskmanager.repository.ConsultaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private ConsultaService consultaService;

    /*  datos de apoyo reutilizables */
    private Usuario usuarioDummy;
    private Consulta inputConsulta;
    private Consulta savedConsulta;

    @BeforeEach
    void init() {
        usuarioDummy = new Usuario();
        usuarioDummy.setNombre("Test");
        usuarioDummy.setEmail("test@example.com");
        usuarioDummy.setRol("consultante");
        usuarioDummy.setEspecialidad("General");

        inputConsulta = new Consulta("¿Qué es X?", usuarioDummy,
                "pregunta", "pendiente", "media");
        savedConsulta = new Consulta("¿Qué es X?", usuarioDummy,
                "pregunta", "pendiente", "media");
        savedConsulta.setId(99L);
    }

    /*  TESTS  */

    @Test
    void findAll_shouldReturnAllConsultas() {
        Consulta c1 = new Consulta("Pregunta A", usuarioDummy,
                "pregunta", "pendiente", "alta");
        Consulta c2 = new Consulta("Pregunta B", usuarioDummy,
                "pregunta", "pendiente", "baja");

        when(consultaRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        List<Consulta> result = consultaService.findAll();

        assertThat(result).hasSize(2).containsExactly(c1, c2);
        verify(consultaRepository).findAll();
    }

    @Test
    void findById_existingId_shouldReturnConsulta() {
        when(consultaRepository.findById(42L)).thenReturn(Optional.of(savedConsulta));

        Optional<Consulta> result = consultaService.findById(42L);

        assertThat(result).isPresent().contains(savedConsulta);
        verify(consultaRepository).findById(42L);
    }

    @Test
    void save_shouldPersistAndReturnConsulta() {
        /* simulamos que la BBDD asigna ID */
        when(consultaRepository.save(any(Consulta.class)))
                .thenAnswer(inv -> {
                    Consulta c = inv.getArgument(0);
                    c.setId(99L);
                    return c;
                });

        Consulta result = consultaService.save(inputConsulta);

        assertThat(result).isNotNull()
                .hasFieldOrPropertyWithValue("id", 99L)
                .usingRecursiveComparison()
                .isEqualTo(savedConsulta);

        verify(consultaRepository).save(inputConsulta);
    }
}
