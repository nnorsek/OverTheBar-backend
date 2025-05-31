package springapi.overthebar_backend;

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
		SpringApplication.run(OverthebarBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(ProgramRepository repo) {
    return args -> {
        if (repo.count() == 0) {
            var sections = List.of(
                new ProgramSection("Warm-Up", 0),
                new ProgramSection("Skill Explanation", 60),
                new ProgramSection("Workout Routine", 120),
                new ProgramSection("Cooldown", 180)
            );

            Program beginner = new Program();
            beginner.setSlug("beginner");
            beginner.setTitle("Beginner Program");
            beginner.setDescription("Start your journey with foundational calisthenics.");
            beginner.setVideoSrc("https://www.youtube.com/embed/kuUZYUBHryw");
            beginner.setLevel("Beginner");
            beginner.setSections(sections);

            repo.save(beginner);
        	}
    	};
	}

}
