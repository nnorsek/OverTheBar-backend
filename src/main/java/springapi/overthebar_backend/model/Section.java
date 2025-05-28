package springapi.overthebar_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sections")
public class Section {

   @Id
   private String id;

   private String label;
   private int time;

   @DBRef
   private Workout workout;

   // Getters and setters
   public String getId() {
       return id;
   }

   public void setId(String id) {
       this.id = id;
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

   public Workout getWorkout() {
       return workout;
   }

   public void setWorkout(Workout workout) {
       this.workout = workout;
   }
}