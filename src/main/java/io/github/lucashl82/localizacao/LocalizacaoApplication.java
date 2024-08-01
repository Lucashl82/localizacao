package io.github.lucashl82.localizacao;

import io.github.lucashl82.localizacao.domain.entity.Cidade;
import io.github.lucashl82.localizacao.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listarCidadesPorNome();
	}

	void listarCidadesPorNome(){
		cidadeRepository.findByNomeLike("%a%").forEach(System.out::println);
	}

	void listarCidadesPorHabitantes(){
		cidadeRepository.findByHabitantes(7000000L).forEach(System.out::println);
	}

	@Transactional
	void salvarCidade(){
		var cidade = new Cidade(1L, "Contagem", 621865L);
		cidadeRepository.save(cidade);
	}

	void listarCidades(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
