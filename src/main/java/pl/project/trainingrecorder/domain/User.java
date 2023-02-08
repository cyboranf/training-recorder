package pl.project.trainingrecorder.domain;

import lombok.Data;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String email;
    @Column(length = 60)
    private String firstName;
    @Column(length = 60)
    private String lastName;
    @Column(length = 100)
    private String password;
    @Transient
    private String matchingPassword;
    @Column(name = "role")
    private String role;
    @OneToMany
    private List<Training> trainingList;
}
