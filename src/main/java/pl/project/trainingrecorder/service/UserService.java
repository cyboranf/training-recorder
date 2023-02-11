package pl.project.trainingrecorder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.repository.UserRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User findByLogged() {
        return userRepository.findByLogged().get(0);
    }

    public int loggedUserTrainingCount() {
        int count = userRepository.findByLogged().get(0).getTrainingList().size();
        return count;
    }

    public long loggedUserBurnedCalories() {
        AtomicLong kcal = new AtomicLong();
        List<Training> trainingList = userRepository.findByLogged().get(0).getTrainingList();

        trainingList.forEach(t -> {
            kcal.addAndGet(t.getTrainingDetails().getKcal());
        });
        return kcal.get();
    }
}
