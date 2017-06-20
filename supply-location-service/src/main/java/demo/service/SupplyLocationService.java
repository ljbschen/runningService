package demo.service;

import demo.domain.SupplyLocation;
import org.springframework.data.geo.Point;

import java.util.List;

public interface SupplyLocationService {
    void saveSupplyLocations(List<SupplyLocation> supplyLocations);

    SupplyLocation findFirstByLocationNear(Point point);

    List<SupplyLocation> findSupplyLocationsNear(Point point, double radius);

    List<SupplyLocation> findSupplyLocationsByType(String type);

    SupplyLocation findFirstByTypeAndLocationNear(String type, Point point);
}
