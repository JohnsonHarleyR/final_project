package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.FinalProject.ArticleApi.ArticleService;
import co.grandcircus.FinalProject.ArticleApi.Result;
import co.grandcircus.FinalProject.Favorites.ArticleDao;
import co.grandcircus.FinalProject.Favorites.FavAffirmation;
import co.grandcircus.FinalProject.Favorites.FavArticle;
import co.grandcircus.FinalProject.NewsApi.Article;
import co.grandcircus.FinalProject.NewsApi.NewsApiService;
import co.grandcircus.FinalProject.User.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
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
	
	@Autowired 
	private ArticleDao articleRepo;
	
	
	
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
		
		
		//Get random CDC article
		Result[] results = articleService.getArticlesByTopic("depression"); 
		//Result[] results = articleService.getArticlesByTopicId(5898); //didn't work
		
		//Initializes random
		Random rand = new Random();
		
	    int length = results.length;
		
	    int articleNumber = rand.nextInt(length);
		
		Result result = results[articleNumber];
	    
	    model.addAttribute("result",result);
		             
		//System.out.println(result.toString());
	    
	    
	    //NEWS API
	    
		
		Article article = newsService.getAArticleByKeyword("Lacking motivation");
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
		
		
		//need to get back from the JSP the user, article name, description, and date
		
		
		
	}
	@PostMapping("/save/article")
	public String saveAffirmation(
			@RequestParam(value = "article") Article article,
			Model model) {
		
		boolean loggedIn = Methods.checkLogin(session);
		
		
		if (!loggedIn) {
			model.addAttribute("loggedin", loggedIn);
		} else {
		
			//Get user
			User user = (User)session.getAttribute("user");
			
			//Get list of their favorite Affirmations
			List<FavArticle> favarticle =
					articleRepo.findByUserId(user.getId());
			
			//errors need to return to refactor 
			//Loop through favorites to see if it exists already
			boolean exists = false;
			for (FavArticle a: favarticle) {
				if (a.getTitle().equals(article.getTitle())) {
					exists = true;
				}
			}
			
			
			//Create new favorite - if it doesn't exist
			if (!exists) {
				
				//Create values for affirmation
				//Date from timestamp
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				Date date=new Date(timestamp.getTime());
				
				//need to get the variable article
				FavArticle favorite = 
						new FavArticle(date, article.getAuthor(), article.getTitle(), 
							article.getDescription(), article.getUrl(), user.getId());
				//Save to favorite
				articleRepo.save(favorite);
			}
			
		}
		
		//Find way to let user know if their save was successful
		
		return "redirect:mind";
	}
}

