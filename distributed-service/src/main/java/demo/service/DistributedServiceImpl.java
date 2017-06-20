package demo.service;

import com.google.common.base.Stopwatch;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import demo.domain.UpdateRequestInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class DistributedServiceImpl implements DistributedService {
    private final static String QUEUE_NAME = "hello";

    @Async
    public Future<Long> uploadAsync(UpdateRequestInfo updateRequestInfo) throws InterruptedException, IOException, TimeoutException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        // push to queue;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
        System.out.println("pushed to queue for " + updateRequestInfo.getRunningId());
        return new AsyncResult<Long>(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
