package springapi.overthebar_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import springapi.overthebar_backend.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    
}
