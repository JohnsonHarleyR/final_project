package co.grandcircus.FinalProject;

import javax.servlet.http.HttpSession;

import co.grandcircus.FinalProject.User.User;

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
	
	
}
