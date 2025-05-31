package springapi.overthebar_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springapi.overthebar_backend.repository.ProgramRepository;
import springapi.overthebar_backend.service.ProgramService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springapi.overthebar_backend.model.Program;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/program")
@CrossOrigin(origins = "*")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    private final ProgramRepository programRepository;

    public ProgramController(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @GetMapping("/{slug}")
    public Optional<Program> getProgramBySlug(@PathVariable String slug) {
        return programRepository.findBySlug(slug);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Program>> getAllPrograms() {
        List<Program> program = programService.getAllPrograms();
        return ResponseEntity.ok(program);
    }
    
}