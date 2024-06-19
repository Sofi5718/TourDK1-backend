package exam.tourDK1.dto;

import exam.tourDK1.entity.Rider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiderDto {
    private int id;
    private String name;
    private LocalDate birthDate;
    private int sprintPoints;
    private int mountainPoints;
    private long totalTime;
    private int teamId;

    public RiderDto(Rider rider){
        this.id = rider.getId();
        this.name = rider.getName();
        this.birthDate = rider.getBirthDate();
        this.sprintPoints = rider.getSprintPoints();
        this.mountainPoints = rider.getMountainPoints();
        this.totalTime = rider.getTotalTime();
        this.teamId = rider.getTeam().getId();
    }
}
