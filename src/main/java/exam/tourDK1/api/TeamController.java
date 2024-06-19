package exam.tourDK1.api;

import exam.tourDK1.entity.Team;
import exam.tourDK1.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable int id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

   @PutMapping("/{id}")
    public Team updateTeam(@PathVariable int id, @RequestBody Team team) {
       Team existingTeam = teamService.getTeamById(id);
       existingTeam.setName(team.getName());
        return teamService.saveTeam(existingTeam);
    }

    @DeleteMapping("/{id}")
    public Team deleteTeam(@PathVariable int id) {
        return teamService.deleteTeam(id);
    }

}
