package pl.project.trainingrecorder.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String role;
}
