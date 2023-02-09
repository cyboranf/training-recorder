package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.trainingrecorder.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
