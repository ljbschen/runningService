package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {
    // add, delete, find, update

    Page<Location> findByRunnerMovementType(@Param("movementType") Location.RunnerMovementType movementType, Pageable pageable);

//    Page<Location> findByUnitInfoCustomerName(@Param("customerName") String customerName, Pageable pageable);

    Page<Location> findByRunningId(@Param("runningId") String runningId, Pageable pageable);

    Page<Location> findByUnitInfoRunningId(@Param("runningId") String runningId, Pageable pageable);
}
