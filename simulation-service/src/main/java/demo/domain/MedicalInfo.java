package demo.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MedicalInfo {
    private String bandMake;
    private String medCode;
    private String medicalInfoId;
    private String medicalInfoClassification;
    private String description;
    private String aidInstructions;
    private long fmi;
    private long bfr;

    public MedicalInfo() {}
}
