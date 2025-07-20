package springapi.overthebar_backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springapi.overthebar_backend.model.ProgramStatusRequest;
import springapi.overthebar_backend.model.ProgramStatusResponse;
import springapi.overthebar_backend.model.User;
import springapi.overthebar_backend.model.UserProgression;
import springapi.overthebar_backend.repository.UserProgressionRepository;
import springapi.overthebar_backend.repository.UserRepository;
import springapi.overthebar_backend.service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProgressionRepository userProgressionRepository;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (userService.getUserByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/progress")
    public ResponseEntity<User> updateProgression(@RequestBody Map<String, Object> body) {
    String email = (String) body.get("email");
    int progression = (int) body.get("progression");

    Optional<User> optionalUser = userService.getUserByEmail(email);
    if (optionalUser.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    User user = optionalUser.get();
    user.setProgression(progression);

    // Determine new level based on progression
    if (progression >= 11) user.setExperienceLevel("Expert");
    else if (progression >= 7) user.setExperienceLevel("Advanced");
    else if (progression >= 3) user.setExperienceLevel("Intermediate");
    else user.setExperienceLevel("Beginner");


    User updated = userService.saveUser(user);

    UserProgression progress = new UserProgression();
    progress.setEmail(email);
    progress.setPoints(progression);
    progress.setMonth(LocalDate.now().withDayOfMonth(1));


    userProgressionRepository.save(progress);

    return ResponseEntity.ok(updated);
}

    @GetMapping("/get")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/program-status")
    public ResponseEntity<ProgramStatusResponse> checkProgramStatus(@RequestBody ProgramStatusRequest request) {
        return userRepository.findByEmail(request.getEmail())
            .map(user -> {
                boolean finished = user.getCompletedPrograms().contains(request.getProgramTitle());
                return ResponseEntity.ok(new ProgramStatusResponse(finished));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/complete-program")
    public ResponseEntity<User> completeProgram(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String programTitle = body.get("programTitle");

        Optional<User> optionalUser = userService.getUserByEmail(email);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();

        List<String> completed = user.getCompletedPrograms();
        if (!completed.contains(programTitle)) {
            completed.add(programTitle);
            user.setCompletedPrograms(completed);
            userService.saveUser(user);
        }

        return ResponseEntity.ok(user);
    }


    @PutMapping("/reset")
    public ResponseEntity<User> resetUserStats(@RequestBody Map<String, String> body) {
        String email = body.get("email");

        Optional<User> optionalUser = userService.getUserByEmail(email);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();
        
        // Reset user stats
        user.setProgression(0);
        user.setExperienceLevel("Beginner");
        user.setCompletedPrograms(new ArrayList<>());

        // Remove all UserProgression data for this user
        userProgressionRepository.deleteByEmail(email);

        // Save and return the updated user
        User updated = userService.saveUser(user);
        User verified = userService.getUserByEmail(email).orElse(updated);
        return ResponseEntity.ok(verified);
}


}