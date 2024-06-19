package exam.tourDK1.service;


import exam.tourDK1.entity.Rider;
import exam.tourDK1.repository.RiderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RiderService {
    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    public List<Rider> getRiderByTeamId(int teamId) {
        return riderRepository.findByTeamId(teamId);
    }

    public Rider getRiderById(int id) {
        return riderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Rider not found"));
    }

    public Rider saveRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public Rider deleteRider(int id) {
        Rider rider = riderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found"));
        riderRepository.deleteById(id);
        return rider;
    }
}
