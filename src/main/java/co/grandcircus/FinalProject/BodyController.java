package co.grandcircus.FinalProject;

import java.util.ArrayList;
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
import co.grandcircus.FinalProject.WorkoutsApi.ExerciseInfo;
import co.grandcircus.FinalProject.WorkoutsApi.Results;
import co.grandcircus.FinalProject.WorkoutsApi.WorkoutService;

@Controller
public class BodyController {

	@Autowired
	private ExcerciseService excerciseService;

	@Autowired
	private WorkoutService workoutService;

	@Autowired
	private HttpSession session;

	@RequestMapping("/body")
	public String body(Model model) {

		boolean loggedIn = Methods.checkLogin(session);

		List<Results> resultList = workoutService.getWorkout();
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("loggedin", loggedIn);

		return "body-page";
	}

	@PostMapping("/body")
	public String bodyWithInput(Model model, @RequestParam(required = false) String userInput) {

		boolean loggedIn = Methods.checkLogin(session);

		ExcerciseTracker excerciseTracker = excerciseService.getTest(userInput);

		List<Exercises> excercises = excerciseTracker.getExercises();

		model.addAttribute("excercises", excercises);
		model.addAttribute("loggedin", loggedIn);

		return "body-page";
	}

}
