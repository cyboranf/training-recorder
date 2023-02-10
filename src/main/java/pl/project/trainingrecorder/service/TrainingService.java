package pl.project.trainingrecorder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.repository.TrainingRepository;

@Service
@Transactional
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training save(Training training) {
        return trainingRepository.save(training);
    }
}
