package pl.project.trainingrecorder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.TrainingDetails;
import pl.project.trainingrecorder.repository.TrainingDetailsRepository;
import pl.project.trainingrecorder.repository.TrainingRepository;

@Service
@Transactional
public class TrainingDetailsService {
    private final TrainingDetailsRepository trainingDetailsRepository;
    private final TrainingRepository trainingRepository;

    public TrainingDetailsService(TrainingDetailsRepository trainingDetailsRepository, TrainingRepository trainingRepository) {
        this.trainingDetailsRepository = trainingDetailsRepository;
        this.trainingRepository = trainingRepository;
    }

    public TrainingDetails save(TrainingDetails trainingDetails) {
        return trainingDetailsRepository.save(trainingDetails);
    }

    public TrainingDetails findById(long id) {
        return trainingDetailsRepository.findById(id).get();
    }

    public void delete(TrainingDetails trainingDetails) {
        trainingDetailsRepository.delete(trainingDetails);
    }
}
