package springapi.overthebar_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springapi.overthebar_backend.model.User;
import springapi.overthebar_backend.service.UserService;

import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

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
        return ResponseEntity.ok(updated);
    }




}
