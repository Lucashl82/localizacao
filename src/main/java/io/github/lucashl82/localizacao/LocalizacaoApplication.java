package io.github.lucashl82.localizacao;

import io.github.lucashl82.localizacao.domain.entity.Cidade;
import io.github.lucashl82.localizacao.domain.repository.CidadeRepository;
import io.github.lucashl82.localizacao.service.CidadeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		Cidade cidade = new Cidade(null, "porto", null);
		cidadeService.listarCidadesByNomeSpec();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
