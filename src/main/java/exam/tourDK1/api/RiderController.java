package exam.tourDK1.api;


import exam.tourDK1.dto.RiderDto;
import exam.tourDK1.entity.Rider;
import exam.tourDK1.service.RiderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/riders")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping
    public List<RiderDto> getAllRiders() {
        return riderService.getAllRiders();
    }

    @GetMapping("/team/{teamId}")
    public List<Rider> getRiderByTeamId(@PathVariable int teamId) {
        return riderService.getRiderByTeamId(teamId);
    }

    @GetMapping("/{id}")
    public RiderDto getRiderById(@PathVariable int id) {
        return riderService.getRiderById(id);
    }

    @PostMapping
    public Rider saveRider(@RequestBody RiderDto rider) {
        return riderService.saveRider(rider);
    }

    @PutMapping("/{id}")
    public Rider updateRider(@PathVariable int id, @RequestBody RiderDto riderDto) {
        return riderService.updateRider(id, riderDto);
    }

    @DeleteMapping("/{id}")
    public Rider deleteRider(@PathVariable int id) {
        return riderService.deleteRider(id);
    }

}
