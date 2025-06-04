package springapi.overthebar_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Program Card")
public class ProgramCard {
    
    @Id
    private String id;

    private String title;
    private String description;
    private List<Image> images;
    private String buttonText;
    private String level;

    public ProgramCard() {
    }

    public ProgramCard(String id, String title, String description, List<Image> images, String buttonText,
            String level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
        this.buttonText = buttonText;
        this.level = level;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }
    public String getButtonText() {
        return buttonText;
    }
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    

}
