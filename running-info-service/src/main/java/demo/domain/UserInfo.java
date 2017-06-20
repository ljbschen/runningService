package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "USER")
public class UserInfo {
    @Id
    @GeneratedValue
    private long Id;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.REMOVE)
    private List<RunningInformation> infoList;

    private String username;
    private String address;
}
