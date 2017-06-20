package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RepositoryRestResource
public interface RunningInfoRepository extends JpaRepository<RunningInformation, Long>{

    @RestResource
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteByRunningId(String runningId);

    @RestResource
    Page<RunningInformation> findAll(Pageable pageable);

    @RestResource
    RunningInformation findByRunningId(String runningId);
}
