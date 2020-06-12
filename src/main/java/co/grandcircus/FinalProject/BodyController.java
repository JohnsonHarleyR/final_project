package co.grandcircus.FinalProject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.FinalProject.ExcerciseApi.ExcerciseService;
import co.grandcircus.FinalProject.ExcerciseApi.ExcerciseTracker;
import co.grandcircus.FinalProject.ExcerciseApi.Exercises;

@Controller
public class BodyController {


	@Autowired
	private ExcerciseService excerciseService;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/body")
	public String body(Model model){
		
		boolean loggedIn = Methods.checkLogin(session);
		 
		//String userInput = "";
		//ExcerciseTracker excerciseTracker = excerciseService.getTest();
		
		//List<Exercises> excercises = excerciseTracker.getExercises();
		
		//model.addAttribute("excercises",excercises);
		
		model.addAttribute("loggedin", loggedIn);
		
		return "body-page";	
	}
	@PostMapping("/body")
	public String bodyWithInput(Model model, @RequestParam (required = false) String userInput){
		
		boolean loggedIn = Methods.checkLogin(session);
		
		ExcerciseTracker excerciseTracker = excerciseService.getTest(userInput);
		
		List<Exercises> excercises = excerciseTracker.getExercises();
		
		model.addAttribute("excercises",excercises);
		
		model.addAttribute("loggedin", loggedIn);
		
		return "body-page";	
	}
	
	
	
	
	
	
	
	
}
