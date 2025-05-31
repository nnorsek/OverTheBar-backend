package springapi.overthebar_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapi.overthebar_backend.model.Program;
import springapi.overthebar_backend.repository.ProgramRepository;

@Service
public class ProgramService {
    
    @Autowired
    private ProgramRepository programRepository;

     public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }
}
