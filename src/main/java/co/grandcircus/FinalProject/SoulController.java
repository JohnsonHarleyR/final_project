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
	private HttpSession session;
	
	
	@RequestMapping("/soul")
	public String soul(Model model) {
		
		//for the header
		boolean loggedIn = Methods.checkLogin(session);
		
		String affirmation = affirmationsService.getAffirmation();
		
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
			}
			
		}
		
		//Find way to let user know if their save was successful
		
		return "redirect:/soul";
	}
	
}
