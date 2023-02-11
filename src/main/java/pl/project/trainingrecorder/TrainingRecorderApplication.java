package pl.project.trainingrecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.project.trainingrecorder.repository.UserRepository;

@SpringBootApplication
public class TrainingRecorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingRecorderApplication.class, args);
    }

}
