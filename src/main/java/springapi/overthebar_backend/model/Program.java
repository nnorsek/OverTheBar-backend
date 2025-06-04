package springapi.overthebar_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "programs")
public class Program {
    
    @Id
    private String id;

    private String slug;
    private String title;
    private List<Image> images;
    private String description;
    private String videoSrc;
    private String level;
    private List<ProgramSection> sections;

    public Program() {
    }

    public Program(String id, List<Image> images, String slug, String title, String description, String videoSrc, String level,
            List<ProgramSection> sections) {
        this.id = id;
        this.images = images;
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.videoSrc = videoSrc;
        this.level = level;
        this.sections = sections;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
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
    public String getVideoSrc() {
        return videoSrc;
    }
    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public List<ProgramSection> getSections() {
        return sections;
    }
    public void setSections(List<ProgramSection> sections) {
        this.sections = sections;
    }

    


}
