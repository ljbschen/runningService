package demo.service;

import demo.domain.SimulationInfo;
import demo.domain.SimulatorRequest;
import org.springframework.data.geo.Point;

import java.util.List;

public interface SimulationService {
    List<Point> parsePolyline(SimulatorRequest simulatorRequest);

    void generateLocations(SimulationInfo simulationInfo);
}
