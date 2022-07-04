package br.com.company.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.company.workshopmongo.domain.Post;
import br.com.company.workshopmongo.domain.User;
import br.com.company.workshopmongo.dto.AuthorDTO;
import br.com.company.workshopmongo.repositories.PostRepository;
import br.com.company.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User us1 = new User(null, "Maria Brown", "maria@gmail.com");
		User us2 = new User(null, "Alex Green", "alex@gmail.com");
		User us3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(us1, us2, us3));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "#partiu", "Vou viajar bla bla bla 1", new AuthorDTO(us3));
		Post post2 = new Post(null, sdf.parse("22/04/2019"), "#partiu", "Vou viajar bla bla bla 2", new AuthorDTO(us2));
		Post post3 = new Post(null, sdf.parse("23/05/2020"), "#partiu", "Vou viajar bla bla bla 3", new AuthorDTO(us1));

		postRepository.saveAll(Arrays.asList(post1, post2, post3));
	}
}
