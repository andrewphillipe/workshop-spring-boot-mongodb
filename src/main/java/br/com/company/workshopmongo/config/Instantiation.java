package br.com.company.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.company.workshopmongo.domain.User;
import br.com.company.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User us1 = new User(null, "Maria Brown", "maria@gmail.com");
		User us2 = new User(null, "Alex Green", "alex@gmail.com");
		User us3 = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(us1, us2, us3));
	}
}
