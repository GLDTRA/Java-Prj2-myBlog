package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    @Autowired
    public UsuarioRepository usuarioRepository;
    @BeforeAll
    void start(){
        usuarioRepository.deleteAll();

        usuarioRepository.save(new Usuario(0L, "Joao da Silva", "joao@email.com", "12345678", "https://i.imgur.com/FETvs20.jpg"));
        usuarioRepository.save(new Usuario(0L, "Maria da Silva", "maria@email.com", "12345678", "https://i.imgur.com/FETvs20.jpg"));
        usuarioRepository.save(new Usuario(0L, "Adrianna da Silva", "adriana@email.com", "12345678", "https://i.imgur.com/FETvs20.jpg"));
        usuarioRepository.save(new Usuario(0L, " Paulo Antunes", "paulo@email.com", "12345678", "https://i.imgur.com/FETvs20.jpg"));
    }

    @Test
    @DisplayName("Retorna 1 usuario")
    public void deveRetornarUmUsuario(){
        Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com");

        assertTrue(usuario.get().getUsuario().equals("joao@email.com"));
    }

    @Test
    @DisplayName("Retorna 3 usuario")
    public void deveRetornarTresUsuario(){
        List<Usuario> listaUsuarios = usuarioRepository.findAllByNameContainingIgnoreCase("Silva");

        assertTrue(listaUsuarios.get(0).getName().equals("Joao da Silva"));
        assertTrue(listaUsuarios.get(1).getName().equals("Maria da Silva"));
        assertTrue(listaUsuarios.get(2).getName().equals("Adrianna da Silva"));
    }

    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }
}
