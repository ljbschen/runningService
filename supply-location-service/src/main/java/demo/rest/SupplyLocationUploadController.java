package demo.rest;

import demo.domain.SupplyLocation;
import demo.domain.SupplyLocationRepository;
import demo.service.SupplyLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplyLocationUploadController {
    private static final String DEFAULT_RADIUS = "50.0";

    private SupplyLocationService service;

    private SupplyLocationRepository repository;

    @Autowired
    public SupplyLocationUploadController(SupplyLocationRepository repository, SupplyLocationService service) {
        this.repository = repository;
        this.service = service;
    }


    @RequestMapping(value = "supplyLocations/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations) {
        this.service.saveSupplyLocations(locations);
    }

    @RequestMapping(value = "/supplyLocations/first", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SupplyLocation findSupplyLocations(@RequestParam("location") Point point) {
        return this.service.findFirstByLocationNear(point);
    }

    @RequestMapping(value = "/supplyLocations/near", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<SupplyLocation> findSupplyLocationsNear(@RequestParam(name = "location") Point point,
                                                        @RequestParam(name = "radius", defaultValue = DEFAULT_RADIUS) String radius) {
        return this.service.findSupplyLocationsNear(point, Double.parseDouble(radius));
    }

    @RequestMapping(value = "/supplyLocations/type", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<SupplyLocation> findSupplyLocationsByType(@RequestParam("type") String type) {
        return this.service.findSupplyLocationsByType(type);
    }

    @RequestMapping(value = "/supplyLocations/firstType", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SupplyLocation findFirstByTypeAndLocationNear(
            @RequestParam("location") Point point,
            @RequestParam("type") String type) {
        return this.service.findFirstByTypeAndLocationNear(type, point);
    }

}
