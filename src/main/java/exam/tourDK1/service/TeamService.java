package exam.tourDK1.service;


import exam.tourDK1.entity.Team;
import exam.tourDK1.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(int id) {
        return teamRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team deleteTeam(int id) {
        Team team = teamRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        teamRepository.deleteById(id);
        return team;
    }
}
