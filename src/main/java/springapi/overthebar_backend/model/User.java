package springapi.overthebar_backend.model;

public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String level;
    private int progression;

    public User(int age, String email, int id, String level, String name, int progression) {
        this.age = age;
        this.email = email;
        this.id = id;
        this.level = level;
        this.name = name;
        this.progression = progression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getProgression() {
        return progression;
    }

    public void setProgression(int progression) {
        this.progression = progression;
    }


    

}
