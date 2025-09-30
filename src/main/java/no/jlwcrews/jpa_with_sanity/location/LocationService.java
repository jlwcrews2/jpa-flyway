package no.jlwcrews.jpa_with_sanity.location;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepo repo;

    public LocationService(LocationRepo repo) {
        this.repo = repo;
    }

    public Location save(Location location) {
        return repo.save(location);
    }

    public Location findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Location> findAll() {
        var result = repo.findAll();
        return result;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
