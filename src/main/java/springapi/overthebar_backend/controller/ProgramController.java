package springapi.overthebar_backend.controller;

import org.springframework.web.bind.annotation.*;
import springapi.overthebar_backend.model.Workout;
import springapi.overthebar_backend.repository.WorkoutRepository;
import springapi.overthebar_backend.service.WorkoutService;

@RestController
@RequestMapping("/api/programs")
public class ProgramController {

    private final WorkoutService workoutService;

    public ProgramController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/{level}")
    public Workout getProgramByLevel(@PathVariable String level) {
        System.out.println("Looking for level: " + level);
        return workoutService.findByLevel(level);
    }
}

