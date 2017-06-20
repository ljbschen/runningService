package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
public class MedicalInfo {
    private Long bfr;
    private Long fmi;

    public MedicalInfo() {

    }
}
