package springapi.overthebar_backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import springapi.overthebar_backend.model.User;

public interface UserRepository extends MongoRepository<User, String> {
   Optional<User> findByEmail(String email);
}
