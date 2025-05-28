package springapi.overthebar_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import springapi.overthebar_backend.model.Workout;
import springapi.overthebar_backend.repository.WorkoutRepository;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout findByLevel(String level) {
        System.out.println("Searching for workout level: '" + level + "'");
        List<Workout> workouts = workoutRepository.findByLevel(level);
        System.out.println("Found workout? " + !workouts.isEmpty());
        return workouts.isEmpty() ? null : workouts.get(0);
    }
    
}

