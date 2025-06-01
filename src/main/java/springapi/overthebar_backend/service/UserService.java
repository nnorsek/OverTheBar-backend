package springapi.overthebar_backend.service;
import java.util.List;
import springapi.overthebar_backend.model.User;
import springapi.overthebar_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean updateUserProgress(String email, int points) {
        Optional<User> optionalUser = getUserByEmail(email);
        if (optionalUser.isEmpty()) return false;
    
        User user = optionalUser.get();
        int updatedProgress = user.getProgression() + points;
        user.setProgression(updatedProgress);
    
        // Update level based on progression
        if (updatedProgress >= 11) user.setExperienceLevel("Expert");
        else if (updatedProgress >= 7) user.setExperienceLevel("Advanced");
        else if (updatedProgress >= 3) user.setExperienceLevel("Intermediate");
        else user.setExperienceLevel("Beginner");
    
        saveUser(user);
        return true;
    }
    
    
}
