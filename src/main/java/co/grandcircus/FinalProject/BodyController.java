package co.grandcircus.FinalProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.ExcerciseApi.ExcerciseService;
import co.grandcircus.FinalProject.ExcerciseApi.ExcerciseTracker;
import co.grandcircus.FinalProject.ExcerciseApi.Exercises;

@Controller
public class BodyController {


	@Autowired
	private ExcerciseService excerciseService;
	
	@RequestMapping("/body")
	public String body(Model model){
		
		ExcerciseTracker excerciseTracker = excerciseService.getTest();
		
		List<Exercises> excercises = excerciseTracker.getExercises();
		
		model.addAttribute("excercises",excercises);
		
		return "body-page";
		
		
		
		
	}
	
}
