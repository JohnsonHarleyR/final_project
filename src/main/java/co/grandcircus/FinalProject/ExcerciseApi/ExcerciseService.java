package co.grandcircus.FinalProject.ExcerciseApi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExcerciseService {
	private RestTemplate rest = new RestTemplate();
	
	
	public ExcerciseTracker getTest() {
		
		String url = "https://trackapi.nutritionix.com/v2/natural/exercise";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-app-key", "0e100605aca7c96583efe9b905f43429");
		headers.add("x-app-id", "16a5577a");
		headers.add("x-remote-user-id", "0");
		
		Map<String, String> personJsonObject = new HashMap<>(); 
		personJsonObject.put("query", "ran 3 miles");
		
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(personJsonObject,headers);
		
		ExcerciseTracker response = rest.postForObject(url, entity, ExcerciseTracker.class);
		System.out.println(response);
		return response;
	}
	
}
