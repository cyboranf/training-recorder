package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.trainingrecorder.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
