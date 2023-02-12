package pl.project.trainingrecorder.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.intellij.lang.annotations.Pattern;

import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, unique = true)
    private String email;
    @Column(length = 60)
    private String userName;
    @Column(length = 60)
    private String lastName;
    @Column(length = 100)
    private String password;
    @Transient
    private String matchingPassword;
    @Column(name = "role")
    private String roles;

    private boolean logged;
    private boolean active;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Training> trainingList;
}
