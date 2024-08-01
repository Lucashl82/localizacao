package io.github.lucashl82.localizacao.service;

import io.github.lucashl82.localizacao.domain.entity.Cidade;
import io.github.lucashl82.localizacao.domain.repository.CidadeRepository;
import static io.github.lucashl82.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public void listarCidadesPorQuantidadeHabitantes(){
        repository.findByHabitantesLessThanAndNomeLike(1000001L, "Br%").forEach(System.out::println);
    }

    public void listarCidadesPorNome(){
        Pageable pageable = PageRequest.of(0, 10);
        repository.findByNomeLike("%a%", pageable).forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        repository.findByHabitantes(7000000L).forEach(System.out::println);
    }


    public void listarCidades(){
        repository.findAll().forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){

        repository
                .findAll(nomeEqual("São Paulo").or(habitantesGreaterThan(1000)))
                .forEach(System.out::println);
    }
}
