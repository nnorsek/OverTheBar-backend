package springapi.overthebar_backend.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_progression")
public class UserProgression {

    @Id
    private String id;

    private String email;
    private LocalDate month;
    private int points;

    public UserProgression() {}

    public UserProgression(String email, LocalDate month, int points) {
        this.email = email;
        this.month = month;
        this.points = points;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public LocalDate getMonth() { return month; }
    public int getPoints() { return points; }

    public void setId(String id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setMonth(LocalDate month) { this.month = month; }
    public void setPoints(int points) { this.points = points; }
}
