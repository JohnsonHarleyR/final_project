package co.grandcircus.FinalProject.NewsApi;

import java.util.List;
import java.util.Random;

import org.springframework.web.client.RestTemplate;



public class NewsApiService {

	private RestTemplate rest = new RestTemplate();
	private String apiKey = "9f36072691b04780b857f211a9279dad";
	
	public Article getAArticleByKeyword(String keyword) {
		
		String url = "https://newsapi.org/v2/everything?q={q}bitcoin&apiKey={apiKey}";
		
		NewsApiResponse response = rest.getForObject(url, NewsApiResponse.class, apiKey, keyword);
		
		List<Article> list = response.getArticles();
		
		Random rand = new Random();
		
	    int length = list.size();
		
	    int articleNumber = rand.nextInt(length);
	    
	    Article article = list.get(articleNumber);
		
		
		
		
		return article;
		
	}
}
