package exam.tourDK1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private int sprintPoints;
    private int mountainPoints;
    private long totalTime;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;


}
