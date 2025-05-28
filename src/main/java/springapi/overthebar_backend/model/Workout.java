package springapi.overthebar_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Document(collection = "workouts")
public class Workout {

   @Id
   private String id;

   private String title;
   private String description;
   private String videoUrl;
   private String level;

   @DBRef
   private List<Section> sections;

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

   public String getVideoUrl() {
       return videoUrl;
   }

   public void setVideoUrl(String videoUrl) {
       this.videoUrl = videoUrl;
   }

   public String getLevel() {
       return level;
   }

   public void setLevel(String level) {
       this.level = level;
   }

   public List<Section> getSections() {
       return sections;
   }

   public void setSections(List<Section> sections) {
       this.sections = sections;
   }
}