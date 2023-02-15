package com.generation.blogpessoal.repository;
import com.generation.blogpessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
// Indica que a Interface é do tipo repositório, ou seja, ela é responsável pela interação
// com o Banco de dados através dos Métodos padrão (Herdados da Interface JPA Repository) e das Query Methods
@Repository
public interface PostagemRespository extends JpaRepository <Postagem, Long> {
    public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
}
