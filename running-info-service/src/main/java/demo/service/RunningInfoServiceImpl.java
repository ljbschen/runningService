package demo.service;

import demo.domain.RunningInfoRepository;
import demo.domain.RunningInformation;
import demo.domain.UserInfo;
import demo.domain.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RunningInfoServiceImpl implements RunningInfoService {

    private RunningInfoRepository runningInfoRepository;
    private UserInfoRepository userInfoRepository;

    @Autowired
    public RunningInfoServiceImpl(RunningInfoRepository runningInfoRepository, UserInfoRepository userInfoRepository) {
        this.runningInfoRepository = runningInfoRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Transactional
    @Override
    public void saveRunningInformation(List<RunningInformation> runningInfo) {
        List<UserInfo> UserInfo = new ArrayList<UserInfo>();
        for (RunningInformation info : runningInfo) {
            if (info.getHeartRate() == 0) {
                info.setHeartRate(new Random().nextInt(141) + 60);
            }
            if (info.getHeartRate() >= 60 && info.getHeartRate() <= 75) {
                info.setHealthWarningLevel(RunningInformation.HealthWarningLevels.LOW);
            } else if (info.getHeartRate() > 75 && info.getHeartRate() <= 120) {
                info.setHealthWarningLevel(RunningInformation.HealthWarningLevels.NORMAL);
            } else {
                info.setHealthWarningLevel(RunningInformation.HealthWarningLevels.HIGH);;
            }
            if (this.findByUsername(info.getUserName()) != null) UserInfo.add(info.getUserInfo());
        }
        this.runningInfoRepository.save(runningInfo);
        this.userInfoRepository.save(UserInfo);
    }

    @Transactional
    @Override
    public void deleteAll() {
        this.runningInfoRepository.deleteAll();
        this.userInfoRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        this.runningInfoRepository.deleteByRunningId(runningId);
    }

    @Override
    public RunningInformation findByRunningId(String runningId) {
        return this.runningInfoRepository.findByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findAllBySingleProperty(Integer page, Integer size, String dir, String field) {
        Pageable pageable = new PageRequest(page, size, (dir.equals("desc")) ? Sort.Direction.DESC : Sort.Direction.ASC, field);
        return this.runningInfoRepository.findAll(pageable);
    }

    @Override
    public UserInfo findByUsername(String userName) {
        return this.userInfoRepository.findByUsername(userName);
    }
}
