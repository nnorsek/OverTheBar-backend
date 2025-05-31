package springapi.overthebar_backend.model;

public class ProgramSection {

    private String label;
    private int time;

    public ProgramSection(String label, int time) {
        this.label = label;
        this.time = time;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    
}
