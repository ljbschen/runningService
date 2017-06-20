package demo.service;

import demo.domain.UpdateRequestInfo;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public interface DistributedService {
    @Async
    Future<Long> uploadAsync(UpdateRequestInfo updateRequestInfo) throws InterruptedException, IOException, TimeoutException;
}
