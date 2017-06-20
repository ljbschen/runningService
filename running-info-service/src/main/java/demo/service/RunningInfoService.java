package demo.service;

import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RunningInfoService {

    void saveRunningInformation(List<RunningInformation> runningInfo);

    void deleteAll();

    void deleteByRunningId(String runningId);

    RunningInformation findByRunningId(String runningId);

    Page<RunningInformation> findAllBySingleProperty(Integer page, Integer size, String sortDir, String field);

    UserInfo findByUsername(String userName);
}
