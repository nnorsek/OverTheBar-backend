package springapi.overthebar_backend.model;

public class ProgramStatusResponse {
    
    private boolean finished;

    public ProgramStatusResponse(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }
}
