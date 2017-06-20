package demo.service;

import demo.domain.SimulatorRequest;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RequestGenerator implements Runnable {
    private static final int TIMEOUT = 5000;

    private List<Point> points;
    private SimulatorRequest simulatorRequest;
    private int reportInterval;

    public RequestGenerator(List<Point> points, SimulatorRequest simulatorRequest) {
        this.points = points;
        this.simulatorRequest = simulatorRequest;
        this.reportInterval = simulatorRequest.getReportInterval();
    }

    @Override
    public void run() {
        for (int i = 0; i < points.size(); i++) {
//            double dx = points.get(i).getX() - points.get(i - 1).getX();
//            double dy = points.get(i).getY() - points.get(i - 1).getY();
//            while (dx * dx + dy * dy >= speed * speed) {
//                // split to small steps
//
//            }
            SimulatorRequestDto simulatorRequestDto = new SimulatorRequestDto(simulatorRequest, points.get(i));
            try {
                String distributedResourceUrl = "http://localhost:9000/distributed/upload";
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<SimulatorRequestDto> request = new HttpEntity<SimulatorRequestDto>(simulatorRequestDto);
                restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
                SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
                        .getRequestFactory();
                rf.setReadTimeout(TIMEOUT);
                rf.setConnectTimeout(TIMEOUT);
                SimulatorRequestDto object = restTemplate.postForObject(distributedResourceUrl, request, SimulatorRequestDto.class);
                // assertion?
            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println("hoho error");
            }
            try {
                Thread.sleep(reportInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish send the object: " + simulatorRequestDto.getRunningId());
        }
    }
}
