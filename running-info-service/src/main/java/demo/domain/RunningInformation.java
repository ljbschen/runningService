package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {
    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;

    public enum HealthWarningLevels {
        LOW, NORMAL, HIGH
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double latitude;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double longitude;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double runningDistance;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date timeStamp;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserInfo userInfo;

    private String runningId;
    private double totalRunningTime;
    private int heartRate;
    private HealthWarningLevels healthWarningLevel;

    public long getUserId() {
        return this.userInfo == null ? null : this.userInfo.getId();
    }

    public String getUserName() {
        return this.userInfo == null ? null : this.userInfo.getUsername();
    }

    public String getUserAddress() {
        return this.userInfo == null ? null : this.userInfo.getAddress();
    }

}

