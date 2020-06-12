package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import co.grandcircus.FinalProject.ArticleApi.ArticleService;
import co.grandcircus.FinalProject.ArticleApi.Result;
import java.util.Random;


@Controller
public class MindController {
	
	@Autowired
	private ArticleService articleService;
	
	
	
	@RequestMapping("/mind")
	public String mindPage(Model model) {
		
		Result[] results = articleService.getArticlesByTopic("anxiety"); 
		
		//Initializes random
		Random rand = new Random();
		
	    int length = results.length;
		
	    int articleNumber = rand.nextInt(length);
		
		Result result = results[articleNumber];
	    
	    model.addAttribute("result",result);
		             
		System.out.println(result.toString());

		return "mind";
		
	}
	
	
}
