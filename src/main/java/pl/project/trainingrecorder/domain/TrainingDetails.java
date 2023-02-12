package pl.project.trainingrecorder.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "training_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "weight")
    private int weight;
    @Column(name = "height")
    private int height;
    @Column(name = "temp", nullable = true)
    private double temp;
    @Column(name = "kcal", nullable = true)
    private long kcal;
    @Column(name = "km")
    private int kilometers;
    @JsonIgnore
    @OneToOne(mappedBy = "trainingDetails")
    private Training training;
}
