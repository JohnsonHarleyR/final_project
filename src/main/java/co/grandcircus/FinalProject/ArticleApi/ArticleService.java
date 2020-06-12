package co.grandcircus.FinalProject.ArticleApi;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ArticleService {
		
		private RestTemplate rest = new RestTemplate();

		public Result[] getArticlesByTopic(String topic) {
			
			String url = "https://tools.cdc.gov/api/v2/resources/media?topic={topic}";
			
			TopicResponse response = rest.getForObject(url, TopicResponse.class, topic);
			
			Result[] articleArray = response.getResults();
			
			return articleArray;
			
		}
//		
//		//Get all categories
//		public Categories getCategories() {
//			
//			String url = "http://quotes.rest/qod/categories.json";
//			
//			QuoteResponse response = rest.getForObject(url, QuoteResponse.class);
//			
//			return response.getContents().getCategories();
//			
//		}
//		
//		
		

	}
	
