package demo;

import demo.domain.Location;
import demo.domain.LocationRepository;
import demo.domain.UnitInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RunningLocationServiceApplication.class)
@WebAppConfiguration
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void whenSaveLocation_expectOK() {
        final String test_runningID = "test_runningId_1";
        this.repository.save(new Location(new UnitInfo(test_runningID)));
        assertThat(this.repository.findByRunningId(test_runningID, new PageRequest(0, 1)).getContent().get(0).getRunningId()).isEqualTo(test_runningID);
    }

    @Test
    public void whenFindByRunningId_expectOK() {
        final String test_runningID = "test_runningId_2";
        this.repository.save(new Location(new UnitInfo(test_runningID)));

    }
}
