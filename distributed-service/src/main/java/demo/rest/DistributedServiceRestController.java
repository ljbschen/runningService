package demo.rest;

import demo.domain.UpdateRequestInfo;
import demo.service.DistributedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
public class DistributedServiceRestController {

    private DistributedService distributedService;

    @Autowired
    public DistributedServiceRestController(DistributedService distributedService) {
        this.distributedService = distributedService;
    }

    @RequestMapping(value = "/distributed/upload", method = RequestMethod.POST)
    public void update(@RequestBody UpdateRequestInfo updateRequestInfo) {
        System.out.println("get request for " + updateRequestInfo.getRunningId());
        try {
            distributedService.uploadAsync(updateRequestInfo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
