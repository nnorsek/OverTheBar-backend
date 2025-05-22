package springapi.overthebar_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(name = "experience_level")
    private String experienceLevel;

    private int progression;

    public User() {
    }

    public User(String email, int id, String experienceLevel, String name, int progression) {
        this.email = email;
        this.id = id;
        this.experienceLevel = experienceLevel;
        this.name = name;
        this.progression = progression;
    }

    // Getters and Setters

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getExperienceLevel() { return experienceLevel; }

    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }

    public int getProgression() { return progression; }

    public void setProgression(int progression) { this.progression = progression; }
}
