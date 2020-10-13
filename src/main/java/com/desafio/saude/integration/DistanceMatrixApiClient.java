package com.desafio.saude.integration;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceMatrixApiClient {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${distance.matrix.endpoint}")
	private String endpoint;

	@Value("${distance.matrix.key}")
	private String key;

	@Value("${distance.matrix.output.format}")
	private String outputFormat;

	public String getDistance(double originLatitude, double originLongitude, double destinationLatitude, double destinationLongitude) {

		String origin = getParametroLatitudeLongitude(originLatitude, originLongitude);
		String destination = getParametroLatitudeLongitude(destinationLatitude, destinationLongitude);
		String url = getUrl(origin, destination);
		
		logger.info(String.format("Realizando request para $s", url));
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				url,
				String.class);

		JSONObject json = new JSONObject(response.getBody()); 
		String distance = getDistanceFromBody(json);
		
		logger.info("Finalizando request para obtencao de distancia");
		
		return distance;
	}

	private String getDistanceFromBody(JSONObject json) {
		return json.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text");
	}

	private String getUrl(String origin, String destination) {
		return endpoint + outputFormat + String.format("?origins=%s&destinations=%s&key=%s", origin, destination, key);
	}

	private String getParametroLatitudeLongitude(double originLatitude, double originLongitude) {
		return String.format("%s,%s", String.valueOf(originLatitude), String.valueOf(originLongitude));
	}
}
