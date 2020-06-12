package co.grandcircus.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.QuoteApi.Quote;
import co.grandcircus.FinalProject.QuoteApi.QuoteService;

@Controller
public class ApiController {
	
	@Autowired
	private QuoteService quoteService;

	@RequestMapping("/")
	public String home (Model model) {
		
		Quote quoteOfDay = quoteService.quoteOfTheDay();
		
		
		model.addAttribute("quote", quoteOfDay);
		
		return "index";
	}
	
}
