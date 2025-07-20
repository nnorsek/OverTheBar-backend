package springapi.overthebar_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import springapi.overthebar_backend.model.UserProgression;

public interface UserProgressionRepository extends MongoRepository<UserProgression, String> {
    List<UserProgression> findByEmailOrderByMonthAsc(String email);

    void deleteByEmail(String email);

}
