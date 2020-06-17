package co.grandcircus.FinalProject;

import java.sql.Date;
import java.sql.Timestamp;
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
import co.grandcircus.FinalProject.Favorites.AffirmationDao;
import co.grandcircus.FinalProject.Favorites.ExerciseDao;
import co.grandcircus.FinalProject.Favorites.FavAffirmation;
import co.grandcircus.FinalProject.Favorites.FavExercises;
import co.grandcircus.FinalProject.FoodApi.FoodService;
import co.grandcircus.FinalProject.FoodApi.Foods;
import co.grandcircus.FinalProject.FoodApi.Nutrients;
import co.grandcircus.FinalProject.User.User;
import co.grandcircus.FinalProject.User.UserDao;
import co.grandcircus.FinalProject.WorkoutsApi.ExerciseInfo;
import co.grandcircus.FinalProject.WorkoutsApi.Results;
import co.grandcircus.FinalProject.WorkoutsApi.WorkoutService;

@Controller
public class BodyController {

	@Autowired
	private UserDao userRepo;
	
	@Autowired
	private ExcerciseService excerciseService;
	
	@Autowired
	private ExerciseDao exerciseRepo;
	
	@Autowired
	private WorkoutService workoutService;
	
	
	@Autowired
	private FoodService foodService;

	@Autowired
	private HttpSession session;

	@RequestMapping("/body")
	public String body(Model model) {

		boolean loggedIn = Methods.checkLogin(session);
		Integer category = (Integer) session.getAttribute("category");
		if (category == null) {
			category = 10;
		}
		
		List<Results> resultList = workoutService.getWorkout(category);
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("loggedin", loggedIn);

		return "body-page";
	}

	@PostMapping("/body")
	public String bodyWithInput(Model model, @RequestParam(required = false) String userInput) {

		boolean loggedIn = Methods.checkLogin(session);

		ExcerciseTracker excerciseTracker = excerciseService.getTest(userInput);

		List<Exercises> exercises = excerciseTracker.getExercises();

		model.addAttribute("exercises", exercises);
		model.addAttribute("loggedin", loggedIn);

		return "body-page";
	}
	@PostMapping("/bodyfood")
	public String foodWithInput(Model model, @RequestParam(required = false) String userInput) {

		boolean loggedIn = Methods.checkLogin(session);

		Nutrients foodTracker = foodService.getTest(userInput);

		List<Foods> food = foodTracker.getFoods();

		model.addAttribute("food", food);
		model.addAttribute("loggedin", loggedIn);

		return "body-page";
	}
	
	@PostMapping("/complete/workout")
	public String completeWorkout(Model model){
		User user = (User)session.getAttribute("user");
		Methods.addWorkoutPoints(user, userRepo);
		return "redirect:/body";
	}
	
	@PostMapping("/save/exercises")
	public String saveExercises(@RequestParam double nf_calories, double duration_min, String name,
			Model model) {
		
		boolean loggedIn = Methods.checkLogin(session);
		
		
		if (!loggedIn) {
			model.addAttribute("loggedin", loggedIn);
		} else {
		
			//Get user
			User user = (User)session.getAttribute("user");
			
		
				
				//Create values for affirmation
				//Date from timestamp
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				Date date=new Date(timestamp.getTime());
				
				
				FavExercises favorite = 
						new FavExercises(date, nf_calories, duration_min, name, user.getId());
				//Save to favorite
				System.out.println(favorite);
				exerciseRepo.save(favorite);
				Methods.addExercisePoints(user, userRepo);
			}
			
		
		//Find way to let user know if their save was successful
		
		return "redirect:/body";
	}
	
	
	

}
