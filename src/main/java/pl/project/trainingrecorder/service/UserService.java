package pl.project.trainingrecorder.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.trainingrecorder.domain.Role;
import pl.project.trainingrecorder.domain.Training;
import pl.project.trainingrecorder.domain.User;
import pl.project.trainingrecorder.repository.RoleRepository;
import pl.project.trainingrecorder.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findRoleByName("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public User findByLogged() {
        return userRepository.findByLogged().get(0);
    }

    public User findUserByName(String name) {
        return userRepository.findUserByuserName(name);
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
