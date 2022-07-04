package br.com.company.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.company.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
