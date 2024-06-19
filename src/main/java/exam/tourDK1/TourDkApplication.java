package exam.tourDK1;

import exam.tourDK1.entity.Rider;
import exam.tourDK1.entity.Team;
import exam.tourDK1.repository.RiderRepository;
import exam.tourDK1.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class TourDkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourDkApplication.class, args);
    }

   @Bean
    public CommandLineRunner importData(TeamRepository teamRepository, RiderRepository riderRepository){
        return args -> {
            Team team1 = new Team();
            team1.setName("Team1");

            Team team2 = new Team();
            team2.setName("Team2");

            teamRepository.save(team1);
            teamRepository.save(team2);

            Rider rider1 = new Rider();
            rider1.setName("Rider1");
            rider1.setTeam(team1);
            rider1.setBirthDate(LocalDate.parse("1990-01-01"));
            rider1.setSprintPoints(100);
            rider1.setMountainPoints(50);
            rider1.setTotalTime(1000);
            riderRepository.save(rider1);

            Rider rider2 = new Rider();
            rider2.setName("Rider2");
            rider2.setTeam(team2);
            rider2.setBirthDate(LocalDate.parse("1995-01-01"));
            rider2.setSprintPoints(200);
            rider2.setMountainPoints(100);
            rider2.setTotalTime(2000);
            riderRepository.save(rider2);

            Rider rider3 = new Rider();
            rider3.setName("Rider3");
            rider3.setTeam(team1);
            rider3.setBirthDate(LocalDate.parse("1993-01-01"));
            rider3.setSprintPoints(300);
            rider3.setMountainPoints(150);
            rider3.setTotalTime(3000);
            riderRepository.save(rider3);
        };
    }
}
