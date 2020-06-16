package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.ArticleApi.ArticleService;
import co.grandcircus.FinalProject.ArticleApi.Result;
import co.grandcircus.FinalProject.NewsApi.Article;
import co.grandcircus.FinalProject.NewsApi.NewsApiService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.http.HttpSession;


@Controller
public class MindController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private NewsApiService newsService;
	
	//List of possible article keywords
	private String[] keywords = {"mental health", "lacking motivation",
			"substance abuse", "anxiety disorders", "self esteem",
			"insomnia", "spirituality", "stress", "trauma", "therapy",
			"autism", "depression", "meditation", "loneliness",
			"suicide prevention", "emotional health", "mental wellbeing",
			"coping with stress", "lifting depression", "overcoming struggle"};
	
	//Articles for body page: healthy eating
	//Articles for soul page: meditation
	
	
	
	//Bailie's API is better.
	//I'd still like to include CDC at the end if I can get something good out of it
	
	//I'm having trouble with getting articles by topic id or multiple words.
	//Maybe I'll still ask the teachers about it
	
	@RequestMapping("/mind")
	public String mindPage(Model model) {
		
		//Topic Ids - test 
		//Depression 5504
		//Mental Health 5898
		
		
		boolean loggedIn = Methods.checkLogin(session);
		
		//Store article keyword - (currently grabs random)
		String keyword = keywords[Math.abs((int)(Math.random() * keywords.length))];
		
		
		//test
		System.out.println(keyword);
		
		
		Article article = newsService.getAArticleByKeyword(keyword);
	    model.addAttribute("article", article);
		System.out.println(article.toString());
	    //Testing area - datetime stuff
	    
	    //Format datetime
	    SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy - h:mm a");
	    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	    
	    //Different ways to format:
	    //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	    //(Question: Is there a necessary format to store it in database?)
	    
	    //TimeStamp (NOTE: Import timestamp SQL, not security)
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    model.addAttribute("time", timestamp);
	    
	    //Format timestamp 
	    //(Do I have to use separate ones, or is there a way to skip line in formatter?)
        String formatted = sdf.format(timestamp);
		model.addAttribute("ftime", formatted);
	    
	    //User stuff
		model.addAttribute("loggedin", loggedIn);

		return "mind";
		
	}
}

