package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SimulationInfo {
    private int numberOfGpsSimulatorRequests;
    private List<SimulatorRequest> gpsSimulatorRequests;

    public SimulationInfo() {

    }
}
