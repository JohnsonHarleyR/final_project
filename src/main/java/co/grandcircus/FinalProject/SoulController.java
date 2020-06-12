package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.QuoteApi.QuoteService;

@Controller
public class SoulController {

	
	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/soul")
	public String soul(Model model) {
		
		boolean loggedIn = Methods.checkLogin(session);
		
		
		
		model.addAttribute("loggedin", loggedIn);
		
		return "soul";
	}
	
	
}
