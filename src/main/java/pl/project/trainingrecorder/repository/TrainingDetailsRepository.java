package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.trainingrecorder.domain.TrainingDetails;

public interface TrainingDetailsRepository extends JpaRepository<TrainingDetails, Long> {
}
