package br.com.company.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.company.workshopmongo.domain.User;
import br.com.company.workshopmongo.dto.UserDTO;
import br.com.company.workshopmongo.repositories.UserRepository;
import br.com.company.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
