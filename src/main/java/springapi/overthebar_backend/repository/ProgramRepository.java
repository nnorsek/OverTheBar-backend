package springapi.overthebar_backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import springapi.overthebar_backend.model.Program;

public interface ProgramRepository extends MongoRepository<Program, String>{
        Optional<Program> findBySlug(String slug);

        boolean existsBySlug(String slug);
}
