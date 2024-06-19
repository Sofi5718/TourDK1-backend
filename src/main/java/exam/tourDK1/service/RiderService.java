package exam.tourDK1.service;


import exam.tourDK1.dto.RiderDto;
import exam.tourDK1.entity.Rider;
import exam.tourDK1.entity.Team;
import exam.tourDK1.repository.RiderRepository;
import exam.tourDK1.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RiderService {
    private final RiderRepository riderRepository;
    private final TeamRepository teamRepository;

    public RiderService(RiderRepository riderRepository, TeamRepository teamRepository) {
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    public List<RiderDto> getAllRiders() {
        return riderRepository.findAll().stream().map(RiderDto::new).toList();
    }

    public List<Rider> getRiderByTeamId(int teamId) {
        return riderRepository.findByTeamId(teamId);
    }

    public RiderDto getRiderById(int id) {
        return riderRepository.findById(id).map(RiderDto::new).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Rider not found"));
    }

    public Rider saveRider(RiderDto riderDto) {
        Rider newRider = new Rider();
        if(riderDto.getId()>0){
            newRider.setId(riderDto.getId());
        }
        return getRider(riderDto, newRider);

    }

    public Rider updateRider(int id, RiderDto riderDto){
        Rider rider = riderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));
        return getRider(riderDto, rider);

    }

    private Rider getRider(RiderDto riderDto, Rider rider) {
        rider.setName(riderDto.getName());
        Team team = teamRepository.findById(riderDto.getTeamId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));
        rider.setTeam(team);
        rider.setBirthDate(riderDto.getBirthDate());
        rider.setSprintPoints(riderDto.getSprintPoints());
        rider.setMountainPoints(riderDto.getMountainPoints());
        rider.setTotalTime(riderDto.getTotalTime());
        return riderRepository.save(rider);
    }

    public Rider deleteRider(int id) {
        Rider rider = riderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));
        riderRepository.deleteById(id);
        return rider;
    }
}
