package springapi.overthebar_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springapi.overthebar_backend.model.UserProgressRequest;
import springapi.overthebar_backend.model.UserProgression;
import springapi.overthebar_backend.service.UserProgressionService;

@RestController
@RequestMapping("/api/progression")
@CrossOrigin(origins = "*")
public class UserProgressionController {

    @Autowired
    private UserProgressionService service;

    @PostMapping("/add")
    public ResponseEntity<UserProgression> addProgress(@RequestBody UserProgressRequest request) {
        UserProgression saved = service.addProgress(request.getEmail(), request.getPoints());
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/history/{email}")
    public ResponseEntity<List<UserProgression>> getProgressionHistory(@PathVariable String email) {
        List<UserProgression> history = service.getProgressForUser(email);
        return ResponseEntity.ok(history);
    }
}

