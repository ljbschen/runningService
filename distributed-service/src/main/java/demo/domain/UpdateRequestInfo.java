package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UpdateRequestInfo {
    public enum RunnerStatus {
        SUPPLY_SOON, NONE
    }

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
    private RunnerStatus runnerStatus;
    private MedicalInfo medicalInfo;


}
