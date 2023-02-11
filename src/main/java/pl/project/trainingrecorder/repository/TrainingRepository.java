package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.User;

import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    Optional<Training> findById(long id);


}
