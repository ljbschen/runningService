package demo.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import demo.domain.SimulatorRequest;
import lombok.Data;
import org.springframework.data.geo.Point;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SimulatorRequestDto {

    private double latitude;
    private double longitude;
    private String address;
    private String headings;

    private SimulatorRequest simulatorRequest;

    public SimulatorRequestDto(SimulatorRequest simulatorRequest, Point p) {
        this.simulatorRequest = simulatorRequest;
        this.latitude = p.getX();
        this.longitude = p.getY();
        // use geocoding to get address + zip from point
    }

}
