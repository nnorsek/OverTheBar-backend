package springapi.overthebar_backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springapi.overthebar_backend.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    
    @Query("SELECT w FROM Workout w WHERE UPPER(w.level) = 'BEGINNER'")
    Optional<Workout> findByLevelIgnoreCaseTest();
}


