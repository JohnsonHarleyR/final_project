package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import co.grandcircus.FinalProject.User.User;
import co.grandcircus.FinalProject.User.UserDao;

public class Methods {
	
	
	//This holds methods needed by all controllers
	
	
	//Check if there's a user logged in
	public static boolean checkLogin(HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		Boolean loggedIn = (Boolean)session.getAttribute("loggedIn");
		
		if (user == null) {
			loggedIn = false;
		} else {
			loggedIn = true;
		}
		
		session.setAttribute("loggedIn", loggedIn);
		//Just to make it so user is logged in longer
		session.setAttribute("user", user);
		
		return loggedIn;
		
	}
	
	//Basic point methods
	
	//Save affirmation (or quote)
	public static void addAffirmationPoints(User user, UserDao repo) {
		//Set number of points it's worth
		final int POINTS = 1; //can grab from challenge list later
		
		user.setPoints(user.getPoints() + POINTS);
		//save user
		repo.save(user);
		
		
		//TODO (check if daily limit is reached before adding)
		
		
		//Later set up to challenges
		
		
	}
	
	
	//Challenges
	
	//Sign up
	public static void signUp(User user) {
		//create instance of challenges list
		
		//(for now just hard code)
		
		//Add 10 points to user
		//save it
		
		
	}
	
	
	
	
	
	
}
