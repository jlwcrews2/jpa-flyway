package no.jlwcrews.jpa_with_sanity.location;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        var result = locationService.findById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocations() {
        var result = locationService.findAll();
        if (result == null || result.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
        return ResponseEntity.ok("Location " + id + " deleted.");
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        var result = locationService.save(location);
        return ResponseEntity.ok(result);
    }
}
