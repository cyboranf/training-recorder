package pl.project.trainingrecorder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.repository.TrainingRepository;

import java.util.List;

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

    public List<Training> trainingList(User user) {
        return user.getTrainingList();
    }

    public Training findById(long id) {
        return trainingRepository.findById(id).get();
    }

    public void delete(Training training) {
        trainingRepository.delete(training);
    }
}
