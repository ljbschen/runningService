package demo.domain;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "supplyLocations")
public interface SupplyLocationRepository extends MongoRepository<SupplyLocation, Long> {
    @RestResource(rel = "by-location")
    SupplyLocation findFirstByLocationNear(@Param("location") Point location);

    SupplyLocation findFirstByTypeAndLocationNear(@Param("type") String type, @Param("location") Point location);

    List<SupplyLocation> findSupplyLocationsByType(@Param("type") String type);
}
