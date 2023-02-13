package pl.project.trainingrecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.trainingrecorder.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByuserName(String userName);

    User findFirstByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE logged = true", nativeQuery = true)
    List<User> findByLogged();
}
