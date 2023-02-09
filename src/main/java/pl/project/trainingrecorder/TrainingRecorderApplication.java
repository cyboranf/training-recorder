package pl.project.trainingrecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.project.trainingrecorder.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class TrainingRecorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingRecorderApplication.class, args);
    }

}
