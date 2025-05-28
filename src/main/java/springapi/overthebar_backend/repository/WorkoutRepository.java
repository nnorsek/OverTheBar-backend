package springapi.overthebar_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import springapi.overthebar_backend.model.Workout;

import java.util.List;

public interface WorkoutRepository extends MongoRepository<Workout, String> {
   List<Workout> findByLevel(String level);
}