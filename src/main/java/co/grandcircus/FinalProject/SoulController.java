package co.grandcircus.FinalProject;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.FinalProject.AffirmationsApi.AffirmationsService;
import co.grandcircus.FinalProject.Favorites.AffirmationDao;
import co.grandcircus.FinalProject.Favorites.FavAffirmation;
import co.grandcircus.FinalProject.QuoteApi.Quote;
import co.grandcircus.FinalProject.QuoteApi.QuoteOfTheDay;
import co.grandcircus.FinalProject.QuoteApi.QuoteOfTheDayDao;
import co.grandcircus.FinalProject.QuoteApi.QuoteService;
import co.grandcircus.FinalProject.User.UserDao;
import co.grandcircus.FinalProject.User.User;

@Controller
public class SoulController {
	
	@Autowired
	private UserDao userRepo;
	
	@Autowired
	private AffirmationDao affirmationRepo;
	
	@Autowired
	private AffirmationsService affirmationsService;
	
	@Autowired
	private QuoteOfTheDayDao quoteRepo;
	
	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private HttpSession session;
	
	//Soul page
	@RequestMapping("/soul")
	public String soul(Model model) {
		
		//for the header
		boolean loggedIn = Methods.checkLogin(session);
		
		//Get an affirmation
		String affirmation = affirmationsService.getAffirmation();
		
		//Kitten Stuff!
		//Get 2 random numbers
		int wi = (int)(Math.random() * 500 + 200);
		int he = (int)(Math.random() * 500 + 200);
		model.addAttribute("wi", wi);
		model.addAttribute("he", he);
		
		//If user is logged in, check to see if it's saved already
		if (loggedIn) {
			
			//Get user
			User user = (User)session.getAttribute("user");
			
			//Get list of their favorite Affirmations
			List<FavAffirmation> affirmations =
					affirmationRepo.findByUserId(user.getId());
			
			
			//Loop through favorites to see if it exists already
			boolean exists = false;
			for (FavAffirmation a: affirmations) {
				if (a.getAffirmation().equals(affirmation)) {
					exists = true;
				}
			}
			
			//Tell the jsp whether it exists or not so that it
			//knows whether to show the save button
			model.addAttribute("exists", exists);
			
		}
		//If the user isn't logged in, we don't need to worry about
		//"exists".
		
		
		//Now check the day, if there's no quote stored in the database for the day,
		//then get a quote from the API to display.
		//Otherwise, grab it from the database.
		
		//First grab a list of database items
		List<QuoteOfTheDay> allPrevious = quoteRepo.findAll();
		
		//Get a timestamp, convert it to date, see if it matches anything in database
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 Date date = new Date(timestamp.getTime());
		 String sDate = date.toString();
		 boolean recorded = false;
		 for (QuoteOfTheDay quote: allPrevious) {
			 if (quote.getDatetime().toString().equals(sDate)) {
				 recorded = true;
				//If it matches anything, add it to the model
				 model.addAttribute("quote", quote);
			 }
		 }
		
		 String qQuote = "";
		 //if it hasn't matched anything, grab a quote from the API. Store it.
		 if (!recorded) {
			 Quote quote = quoteService.quoteOfTheDay();
			 QuoteOfTheDay quoteOfDay = new QuoteOfTheDay(date,
					 quote.getQuote(), quote.getAuthor());
			 quoteRepo.save(quoteOfDay);
			 String quoteString = "";
			 if (quoteOfDay.getAuthor().equals(null) ||
					 quoteOfDay.getAuthor().equals("")) {
				 quoteString = quoteOfDay.getQuote();
			 } else {
				 quoteString = quoteOfDay.getQuote() + " -" + quoteOfDay.getAuthor();
			 }
			 
			 model.addAttribute("quote", quote);
			 model.addAttribute("quotestring", quoteString);
			 qQuote = quote.getQuote();
		 }
		 
		//Loop through favorites to see if quote exists already
		 
		 
		//If user is logged in, check to see if it's saved already
		if (loggedIn) {
			
			//Get user
			User user = (User)session.getAttribute("user");
		//Get list of their favorite Affirmations
			List<FavAffirmation> affirmations =
					affirmationRepo.findByUserId(user.getId());
			
			boolean qExists = false;
			for (FavAffirmation a: affirmations) {
				if (a.getAffirmation().contains(qQuote)) {
					qExists = true;
				}
			}
			//Tell the jsp whether it exists or not so that it
			//knows whether to show the save button
			model.addAttribute("qexists", qExists);
		}
		
		
		 
		
		model.addAttribute("affirmation", affirmation);
		
		//for the header
		model.addAttribute("loggedin", loggedIn);
		
		return "soul";
	}
	
	
	
	
	
	@PostMapping("/save/affirmation")
	public String saveAffirmation(
			@RequestParam(value = "affirmation") String affirmation,
			Model model) {
		
		boolean loggedIn = Methods.checkLogin(session);
		
		//If not logged in, skip the rest basically
		if (!loggedIn) {
			model.addAttribute("loggedin", loggedIn);
		} else {
		
			//Get user
			User user = (User)session.getAttribute("user");
			
			//Get list of their favorite Affirmations
			List<FavAffirmation> affirmations =
					affirmationRepo.findByUserId(user.getId());
			
			
			//Loop through favorites to see if it exists already
			boolean exists = false;
			for (FavAffirmation a: affirmations) {
				if (a.getAffirmation().equals(affirmation)) {
					exists = true;
				}
			}
			
			
			//Create new favorite - if it doesn't exist
			if (!exists) {
				
				//Create values for affirmation
				//Date from timestamp
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				Date date=new Date(timestamp.getTime());
				
				
				FavAffirmation favorite = 
						new FavAffirmation(date, affirmation, user.getId());
				//Save to favorite
				affirmationRepo.save(favorite);
				
				//Add points to user
				Methods.addAffirmationPoints(user, userRepo);
				
			}
			
		}
		
		//Find way to let user know if their save was successful
		
		return "redirect:/soul";
	}
	
}
