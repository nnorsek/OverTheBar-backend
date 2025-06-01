package springapi.overthebar_backend;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        if (!repo.existsBySlug("stretching-and-mobility")) {
            var sections = List.of(
                new ProgramSection("Warm-Up", 0),
                new ProgramSection("Skill Explanation", 60),
                new ProgramSection("Workout Routine", 120),
                new ProgramSection("Cooldown", 180)
            );

            Program stretchingAndMobility = new Program();
            stretchingAndMobility.setSlug("stretching-and-mobility");
            stretchingAndMobility.setTitle("Stretching and Mobility Program");
            stretchingAndMobility.setDescription("The first step to every workout.");
            stretchingAndMobility.setVideoSrc("https://www.youtube.com/embed/bg5ltVL3fok");
            stretchingAndMobility.setLevel("beginner");
            stretchingAndMobility.setSections(sections);

            repo.save(stretchingAndMobility);
        }
    };
}

}
