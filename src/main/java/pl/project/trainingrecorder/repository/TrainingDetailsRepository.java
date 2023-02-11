package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.TrainingDetails;

import java.util.Optional;

public interface TrainingDetailsRepository extends JpaRepository<TrainingDetails, Long> {
    Optional<TrainingDetails> findById(long id);
}
