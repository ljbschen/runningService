package demo.service.impl;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyLocationServiceImpl implements SupplyLocationService {

    SupplyLocationRepository repository;

    @Autowired
    public SupplyLocationServiceImpl(SupplyLocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveSupplyLocations(List<SupplyLocation> supplyLocations) {
        this.repository.save(supplyLocations);
    }

    @Override
    public SupplyLocation findFirstByLocationNear(Point point) {
        return this.repository.findFirstByLocationNear(point);
    }

    @Override
    public List<SupplyLocation> findSupplyLocationsNear(Point point, double radius) {
        List<SupplyLocation> all = this.repository.findAll();
        List<SupplyLocation> result = new ArrayList<>();
        for (SupplyLocation location : all) {
            double dx = location.getLocation().getX() - point.getX();
            double dy = location.getLocation().getY() - point.getY();
            if (dx * dx + dy * dy <= radius) result.add(location);
        }
        return result;
    }

    @Override
    public List<SupplyLocation> findSupplyLocationsByType(String type) {
        return this.repository.findSupplyLocationsByType(type);
    }

    @Override
    public SupplyLocation findFirstByTypeAndLocationNear(String type, Point point) {
        return this.repository.findFirstByTypeAndLocationNear(type, point);
    }
}
