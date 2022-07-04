package br.com.company.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.company.workshopmongo.domain.Post;
import br.com.company.workshopmongo.repositories.PostRepository;
import br.com.company.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return postRepository.findByTitle(text);
	}

	public List<Post> fullTextSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullTextSearch(text, minDate, maxDate);
	}

}
