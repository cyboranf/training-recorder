package pl.project.trainingrecorder.domain;

import lombok.*;
import org.intellij.lang.annotations.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "training")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "training_day")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate trainingDay;

    @Column(name = "training_time")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime trainingTime;

    @Column(name = "description")
    @Nullable
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private TrainingDetails trainingDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
