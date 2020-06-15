package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.AffirmationsApi.AffirmationsService;
import co.grandcircus.FinalProject.QuoteApi.Quote;
import co.grandcircus.FinalProject.QuoteApi.QuoteService;

@Controller
public class SoulController {

	
	
	@Autowired
	private AffirmationsService affirmationsService;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/soul")
	public String soul(Model model) {
		
		//for the header
		boolean loggedIn = Methods.checkLogin(session);
		
		String affirmation = affirmationsService.getAffirmation();
		
		
		model.addAttribute("affirmation", affirmation);
		
		
		//for the header
		model.addAttribute("loggedin", loggedIn);
		
		return "soul";
	}
	
	
}
