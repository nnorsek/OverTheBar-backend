package springapi.overthebar_backend.controller;

import springapi.overthebar_backend.model.Workout;
import springapi.overthebar_backend.repository.WorkoutRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @GetMapping("/test")
public List<String> getAllLevels() {
    List<Workout> workouts = workoutRepository.findAll();
    workouts.forEach(w -> System.out.println("Level: " + w.getLevel()));
    return workouts.stream().map(Workout::getLevel).toList();
}

}

