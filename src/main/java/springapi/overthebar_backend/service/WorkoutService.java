package springapi.overthebar_backend.service;

import org.springframework.stereotype.Service;
import springapi.overthebar_backend.model.Workout;
import springapi.overthebar_backend.repository.WorkoutRepository;
import java.util.Optional;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout findByLevel(String level) {
        System.out.println("Searching for workout level: '" + level + "'");
        Optional<Workout> workoutOpt = workoutRepository.findByLevelIgnoreCaseTest();
        System.out.println("Found workout? " + workoutOpt.isPresent());
        return workoutOpt.orElseThrow(() -> new RuntimeException("Workout not found"));
    }
    
}

