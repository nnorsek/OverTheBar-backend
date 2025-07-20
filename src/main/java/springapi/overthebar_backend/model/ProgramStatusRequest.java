package springapi.overthebar_backend.model;

public class ProgramStatusRequest {
    
    private String email;
    private String programTitle;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProgramTitle() {
        return programTitle;
    }
    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }
    
}
