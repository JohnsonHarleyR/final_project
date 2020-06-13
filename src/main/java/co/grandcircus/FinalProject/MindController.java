package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.ArticleApi.ArticleService;
import co.grandcircus.FinalProject.ArticleApi.Result;
import java.util.Random;

import javax.servlet.http.HttpSession;


@Controller
public class MindController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private HttpSession session;
	

	
	//I'm having trouble with getting articles by topic id or multiple words,
	//Bailie's API is better. Maybe I'll still ask the teachers about it too.
	
	@RequestMapping("/mind")
	public String mindPage(Model model) {
		
		boolean loggedIn = Methods.checkLogin(session);
		
		//Topic Ids - test 
		//Depression 5504
		//Mental Health 5898
		
		Result[] results = articleService.getArticlesByTopic("depression"); 
		//Result[] results = articleService.getArticlesByTopicId(5898); //didn't work
		
		//Initializes random
		Random rand = new Random();
		
	    int length = results.length;
		
	    int articleNumber = rand.nextInt(length);
		
		Result result = results[articleNumber];
	    
	    model.addAttribute("result",result);
		             
		System.out.println(result.toString());
		
		model.addAttribute("loggedin", loggedIn);

		return "mind";
		
	}
}

