package br.com.mycrud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mycrud.domain.Usuario;
import br.com.mycrud.repositories.UsuarioRepository;

@SpringBootApplication
// Devo implementar o commandLine runner
public class VendasApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Rafael Santos", "rafael.santos", "123456");
		Usuario u2 = new Usuario(null, "Bruna Santos", "bru.santos", "123456");
		Usuario u3 = new Usuario(null, "Lenice Stravenga", "le.strav", "123456");
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
