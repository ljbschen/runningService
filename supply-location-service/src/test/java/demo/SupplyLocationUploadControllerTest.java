package demo;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.rest.SupplyLocationUploadController;
import demo.service.SupplyLocationService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class SupplyLocationUploadControllerTest {

    private SupplyLocationRepository repository;

    private SupplyLocationService service;

    private SupplyLocationUploadController controller;

    private List<SupplyLocation> inputLocations;

    @Before
    public void SetupMock() {
        repository = mock(SupplyLocationRepository.class);
        service = mock(SupplyLocationService.class);
        controller = new SupplyLocationUploadController(repository, service);
        // add locations to the input
    }

    @Test
    public void whenListFiltered_returnList() {
        List<SupplyLocation> locations = new ArrayList<>();

    }


}
