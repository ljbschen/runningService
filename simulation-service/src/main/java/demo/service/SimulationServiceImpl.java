package demo.service;

import demo.domain.SimulationInfo;
import demo.domain.SimulatorRequest;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationServiceImpl implements SimulationService {
    @Override
    public List<Point> parsePolyline(SimulatorRequest simulatorRequest) {
        String polyline = simulatorRequest.getEncodedPolyline();
        PolyLineDecoder decoder = new PolyLineDecoder();
        return decoder.decodePoly(polyline);
    }

    @Override
    public void generateLocations(SimulationInfo simulationInfo) {
        for (SimulatorRequest request : simulationInfo.getGpsSimulatorRequests()) {
            List<Point> points = parsePolyline(request);
            int speed = request.getSpeed();
            Runnable r = new RequestGenerator(points, speed);
            new Thread(r).start();
        }
    }
}
