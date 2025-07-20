package springapi.overthebar_backend.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private String experienceLevel;
    private int progression;
    private List<String> completedPrograms = new ArrayList<>();

    public User() {
    }

  

    public User(String email, String id, String experienceLevel, String name, int progression, List<String> completedPrograms) {
        this.email = email;
        this.id = id;
        this.experienceLevel = experienceLevel;
        this.name = name;
        this.progression = progression;
        this.completedPrograms = completedPrograms;
    }


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getExperienceLevel() { return experienceLevel; }

    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }

    public int getProgression() { 
        System.out.println("getProgression called, value=" + this.progression); 
        return progression; 
    }

    public void setProgression(int progression) { this.progression = progression; }

    public List<String> getCompletedPrograms() {
        return completedPrograms;
    }

    public void setCompletedPrograms(List<String> completedPrograms) {
        this.completedPrograms = completedPrograms;
    }
}
