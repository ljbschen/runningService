package demo.service;

import demo.domain.SimulatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RequestGenerator implements Runnable {
    private List<Point> points;
    private SimulatorRequest simulatorRequest;

    @Autowired
    private ClientHttpRequestFactory clientHttpRequestFactory;

    public RequestGenerator(List<Point> points, SimulatorRequest simulatorRequest) {
        this.points = points;
        this.simulatorRequest = simulatorRequest;
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

            String distributedResourceUrl = "";
            RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
            HttpEntity<SimulatorRequest> request = new HttpEntity<SimulatorRequest>(simulatorRequest);
            SimulatorRequest object = restTemplate.postForObject(distributedResourceUrl, request, SimulatorRequest.class);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendPost() {

    }
}
