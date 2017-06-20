package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInfoRestController {

    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SIZE = "2";
    private static final String DEFAULT_DIR = "desc";
    private static final String DEFAULT_FIELD = "heartRate";


    private RunningInfoService runningInfoService;

    @Autowired
    public RunningInfoRestController(RunningInfoService runningInfoService) {
        this.runningInfoService = runningInfoService;
    }

    @RequestMapping(value = "runningInfo/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInfo) {
        this.runningInfoService.saveRunningInformation(runningInfo);
    }

    @RequestMapping(value = "runningInfo/purge", method = RequestMethod.DELETE)
    public void purge() {
        this.runningInfoService.deleteAll();
    }

    @RequestMapping(value = "/runningInfo/deleteByRunningId", method = RequestMethod.DELETE)
    public void deleteByRunningId(@RequestParam(name = "runningId") String runningId) {
        this.runningInfoService.deleteByRunningId(runningId);
    }

    @RequestMapping(path = "/runningInfo", method = RequestMethod.GET)
    public Page<RunningInformation> findAllBySingleProperty(
            @RequestParam(name = "page", defaultValue = DEFAULT_PAGE) Integer page,
            @RequestParam(name = "size", defaultValue = DEFAULT_SIZE) Integer size,
            @RequestParam(name = "sortDir", defaultValue = DEFAULT_DIR) String dir,
            @RequestParam(name = "field", defaultValue = DEFAULT_FIELD) String field) {
        return this.runningInfoService.findAllBySingleProperty(page, size, dir, field);
    }
}
