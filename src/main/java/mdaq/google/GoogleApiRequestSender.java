package mdaq.google;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
public class GoogleApiRequestSender {

    private final static String GOOGLE_ENCODED_API_KEY = "QUl6YVN5Qk9teW01Z0pweGozLXotdmQ3VzZVdS1HVm5GNDdrbDZ3";

    public Coordinator getDistanceBetweenCoordinators(DistancePair distancePair) throws IOException, InterruptedException {
        var decodedAPIKey = new String(Base64.getDecoder().decode(GOOGLE_ENCODED_API_KEY));

        var coordinator = new Coordinator(distancePair.getOrigin(), distancePair.getDestination());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                                + URLEncoder.encode(coordinator.getOrigin().getPlusCode(), StandardCharsets.US_ASCII)
                                + "&destinations="
                                + URLEncoder.encode(coordinator.getDestination().getPlusCode(), StandardCharsets.US_ASCII)
                                + "&key="
                                + decodedAPIKey))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var distance = JsonPath.parse(response.body()).read("$.rows[0].elements[0].distance.value").toString();
        coordinator.setDistance(Long.parseLong(distance));

        log.debug("Distance between origin {}-{} and destination {}-{} is [{}]", coordinator.getOrigin().getJunctionName(), coordinator.getOrigin().getPlusCode(), coordinator.getDestination().getJunctionName(), coordinator.getDestination().getPlusCode(), coordinator.getDistance());
        return coordinator;
    }


}
