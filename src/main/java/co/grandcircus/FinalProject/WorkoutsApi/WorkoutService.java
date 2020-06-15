package co.grandcircus.FinalProject.WorkoutsApi;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorkoutService {
	private RestTemplate rest = new RestTemplate();
	
	public List<Results> getWorkout() {
		
		String url = "https://wger.de/api/v2/exercise/?language=2&status=2";

		
		ExerciseInfo response = rest.getForObject(url, ExerciseInfo.class);
		
		List<Results> exercise = response.getResults();

		return exercise;
		
		
		
	}

}
