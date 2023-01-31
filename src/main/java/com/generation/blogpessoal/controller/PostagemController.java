package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*
Receberá requisições que serão compostas por:
URL: Endereço da requisição (endpoint)
Verbo: Define qual Método HTTP será acionado na Classe controladora.
Corpo da requisição (Request Body):
Objeto que contém os dados que serão persistidos no Banco de dados.
*/
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //Permite que o frontend (heroku e outros) acesse por qualquer domínio:
//Geralmente , substitui o * pelo url do
public class PostagemController {
    @Autowired
    private PostagemRespository postagemRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postagemRepository.save(postagem));
    }
}
