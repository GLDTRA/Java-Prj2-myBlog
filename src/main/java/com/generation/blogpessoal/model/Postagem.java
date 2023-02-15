package com.generation.blogpessoal.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

@Entity //Entidade - será a Postagem
@Table(name = "tb_postagens")
public class Postagem {
    //CRIACAO DE ATRIBUTOS NO DB
    @Id //criar um pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //gerar o pk como auto increment
    private long id; //pk

    @NotBlank // not null e not empty
    @Size(min = 2, max = 100, message = "O atributo terá que ter no mínimo 5 e no máximo 100!!")
    private String titulo;

    @NotBlank
    @Size(min = 10, max = 1000)
    private String texto;
    @UpdateTimestamp //Verificar o tempo que foi criado
    private LocalDate data;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Usuario users;

    public Usuario getUsers() {
        return users;
    }

    public void setUsers(Usuario users) {
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
