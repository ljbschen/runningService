package demo.rest;

import demo.domain.SimulationInfo;
import demo.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulatorRestController {

    private SimulationService simulationService;

    @Autowired
    public SimulatorRestController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @RequestMapping(value = "/simulator/generate", method = RequestMethod.POST)
    public void generateLocations(@RequestBody SimulationInfo simulationInfo) {
        simulationService.generateLocations(simulationInfo);
    }

}
