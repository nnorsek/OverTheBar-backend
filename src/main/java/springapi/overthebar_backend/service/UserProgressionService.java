package springapi.overthebar_backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapi.overthebar_backend.model.UserProgression;
import springapi.overthebar_backend.repository.UserProgressionRepository;

@Service
public class UserProgressionService {

    @Autowired
    private UserProgressionRepository repository;

    public UserProgression addProgress(String email, int points) {
        LocalDate now = LocalDate.now().withDayOfMonth(1);
        UserProgression progress = new UserProgression(email, now, points);
        return repository.save(progress);
    }

    public List<UserProgression> getProgressForUser(String email) {
        return repository.findByEmailOrderByMonthAsc(email);
    }
}

