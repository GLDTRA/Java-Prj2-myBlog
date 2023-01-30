package com.generation.blogpessoal.controller;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*
Receberá requisições que serão compostas por:
URL: Endereço da requisição (endpoint)
Verbo: Define qual Método HTTP será acionado na Classe controladora.
Corpo da requisição (Request Body):
Objeto que contém os dados que serão persistidos no Banco de dadas. Nem toda a
requisição enviará dados no Corpo da Requisição.
*/
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") //Permite que o frontend (heroku e outros) acesse por qualquer domínio:
//Geralmente , substitui o * pelo url do
public class PostagemController {
    @Autowired //
    private PostagemRespository postagemRepository;


    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }
}
