package br.com.company.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.company.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1","maria", "maria@maria.com.br");
		User alex = new User("1","alex", "alex@alex.com.br");
		List<User> users = Arrays.asList(maria, alex);
		return ResponseEntity.ok().body(users);
	}
}
