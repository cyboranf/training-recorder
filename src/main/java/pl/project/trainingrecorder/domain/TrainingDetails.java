package pl.project.trainingrecorder.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "training_detail")
@Data
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
    @Column(name = "kcal",nullable = true)
    private long kcal;
    @Column(name = "km")
    private int kilometers;


}
