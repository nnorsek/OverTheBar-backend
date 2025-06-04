package springapi.overthebar_backend;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springapi.overthebar_backend.model.Image;
import springapi.overthebar_backend.model.Program;
import springapi.overthebar_backend.model.ProgramSection;
import springapi.overthebar_backend.repository.ProgramRepository;

@SpringBootApplication
public class OverthebarBackendApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
        System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
		SpringApplication.run(OverthebarBackendApplication.class, args);
	}

	@Bean
    CommandLineRunner seed(ProgramRepository repo) {
    return args -> {
        if (!repo.existsBySlug("dips-made-easy")) {
            var sections = List.of(
                new ProgramSection("Warm-Up", 0),
                new ProgramSection("Skill Explanation", 60),
                new ProgramSection("Workout Routine", 120),
                new ProgramSection("Cooldown", 180)
            );
            var images = List.of(
                new Image("/images/dips.webp", "Dips")
            );

            Program dipsMadeEasy = new Program();
            dipsMadeEasy.setSlug("dips-made-easy");
            dipsMadeEasy.setTitle("Dips Made Easy");
            dipsMadeEasy.setImages(images);
            dipsMadeEasy.setDescription("Build upper body strength with simple, effective dip progressions for all levels.");
            dipsMadeEasy.setVideoSrc("https://www.youtube.com/embed/2z8JmcrW-As");
            dipsMadeEasy.setLevel("beginner");
            dipsMadeEasy.setSections(sections);

            repo.save(dipsMadeEasy);
        }
    };
}

}
