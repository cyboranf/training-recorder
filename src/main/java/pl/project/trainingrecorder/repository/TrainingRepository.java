package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.trainingrecorder.domain.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
