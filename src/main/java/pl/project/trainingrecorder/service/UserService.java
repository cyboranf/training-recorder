package pl.project.trainingrecorder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.repository.UserRepository;

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

    public User findByLogged(){
        return userRepository.findByLogged().get(0);
    }
}
