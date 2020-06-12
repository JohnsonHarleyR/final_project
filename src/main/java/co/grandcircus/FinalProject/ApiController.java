package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.ArticleApi.ArticleService;
import co.grandcircus.FinalProject.ArticleApi.Result;
import co.grandcircus.FinalProject.QuoteApi.Quote;
import co.grandcircus.FinalProject.QuoteApi.QuoteService;

@Controller
public class ApiController {
	
	@Autowired
	private QuoteService quoteService;
	
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/")
	public String home (Model model) {
		
		Quote quoteOfDay = quoteService.quoteOfTheDay();
		
		model.addAttribute("quote", quoteOfDay);
		
		return "index";
	}
	
	@RequestMapping("/mind")
	public String mindPage(Model model) {
		
		Result[] results = articleService.getArticlesByTopic("depression"); 
		
	    Result result = results[1];
	    
	    model.addAttribute("result",result);
		             
		System.out.println(result.toString());

		return "mind";
		
	}
	
	
	
}
