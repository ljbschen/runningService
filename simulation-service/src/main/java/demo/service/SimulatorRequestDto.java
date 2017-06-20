package demo.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import demo.domain.MedicalInfo;
import demo.domain.SimulatorRequest;
import lombok.Data;
import org.springframework.data.geo.Point;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SimulatorRequestDto {

    private double latitude;
    private double longitude;
    private String address;
    private String zip;
    private String headings;
    private String runningId;
    private double speed;
    private boolean move;
    private boolean exportPositionsToMessaging;
    private int reportInterval;
    private int secondsToError;
    private SimulatorRequest.RunnerStatus runnerStatus;
    private MedicalInfo medicalInfo;

    public SimulatorRequestDto(SimulatorRequest simulatorRequest, Point p) {
        this.latitude = p.getX();
        this.longitude = p.getY();
        this.runningId = simulatorRequest.getRunningId();
        this.speed = simulatorRequest.getSpeed();
        this.move = simulatorRequest.isMove();
        this.exportPositionsToMessaging = simulatorRequest.isExportPositionsToMessaging();
        this.reportInterval = simulatorRequest.getReportInterval();
        this.secondsToError = simulatorRequest.getSecondsToError();
        this.runnerStatus = simulatorRequest.getRunnerStatus();
        this.medicalInfo = simulatorRequest.getMedicalInfo();
        // use geocoding to get address + zip from point
        this.address = "1111 First Street";
        this.zip = "11111";
        this.headings = "N";
    }

}
