package io.github.lucashl82.localizacao.domain.repository;

import io.github.lucashl82.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //busca pelo nome exato
    List<Cidade> findByNome(String nome);

    //busca pelo nome like
    @Query( " select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome);

    //busca pelo nome começando por aquele trecho
    List<Cidade> findByNomeStartingWith(String nome);

    //busca pelo nome terminando por aquele trecho
    List<Cidade> findByNomeEndingWith(String nome);

    //busca pelo nome contantedo por aquele trecho
    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

}
