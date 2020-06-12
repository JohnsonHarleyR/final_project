package co.grandcircus.FinalProject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.FinalProject.QuoteApi.Quote;
import co.grandcircus.FinalProject.QuoteApi.QuoteService;
import co.grandcircus.FinalProject.User.User;
import co.grandcircus.FinalProject.User.UserDao;




@Controller
public class HomeController {
	
	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private UserDao userRepo;

	// This tells the navigation bar and favorites page whether a
	// user is logged in.
	private boolean loggedIn = false;
	private int page = 1;;
	private String loginMessage = "Please enter your username and password.";
	private String signUpMessage = "Please enter the following information.";
	private String infoMessage = "Here is your user information.";
	private String editMessage = "Edit your user info here.";
	

	@RequestMapping("/")
	public String home (Model model) {
		
		Quote quoteOfDay = quoteService.quoteOfTheDay();
		
		model.addAttribute("quote", quoteOfDay);
		
		return "index";
	}
	
	
	
	
	
	// USER PAGES

		// Favorites page
		@RequestMapping("/favorite")
		public String favorites(Model model) {

			// get user
			User user = (User) session.getAttribute("user");
			
			//Check if logged in
			checkLogin();
			

			model.addAttribute("loggedin", loggedIn);
			
			
			
			// If user is not logged in, redirect to login page
			if (!loggedIn) {
				model.addAttribute("loggedin", loggedIn);
				return "redirect:/login";
			} else {
				model.addAttribute("user", user);
				return "favorite";
			}

		}

		// Login page
		@RequestMapping("/login")
		public String login(Model model) {

			// tell nav bar whether user is logged in
			model.addAttribute("loggedin", loggedIn);
			model.addAttribute("message", loginMessage);

			return "login";
		}

		// Login submit
		@PostMapping("/login/submit")
		public String submit(@RequestParam("identity") String identity, @RequestParam String password, Model model,
				RedirectAttributes redir // not sure what this does? Pass to another method? useful
		) {

			User user;

			// see if user exists
			// find out if it's an email or username
			if (identity.contains("@")) {
				user = userRepo.findByEmail(identity);
			} else {
				user = userRepo.findByUsername(identity);
			}

			// 1. user is found
			// - or -
			// 2. password is incorrect

			if (user == null || !password.contentEquals(user.getPassword())) {
				loginMessage = "Your username, email, or password was incorrect.";
				model.addAttribute("message", loginMessage);
				loggedIn = false;
				return "redirect:/login";
			} else {
				loggedIn = true;
			}

			// add data to the session? not sure I understand this part fully yet
			session.setAttribute("user", user);

			// I don't think this is actually needed with the way I'm doing it
			// but it is a nifty thing
			//redir.addFlashAttribute("message", "You are now logged in, " + user.getName() + ".");

			return "redirect:/";
		}

		// Logout
		@RequestMapping("/logout")
		public String logout(RedirectAttributes redir) {

			loginMessage = "Please enter your username and password.";
			signUpMessage = "Please enter the following information.";
			infoMessage = "Here is your user information.";
			editMessage = "Edit your user info here.";

			// removes objects added to session

			session.invalidate();
			loggedIn = false;
			return "redirect:/login";
		}

		// Sign up page
		@RequestMapping("/sign-up")
		public String signUp(Model model) {

			// tell nav bar whether user is logged in
			model.addAttribute("loggedin", loggedIn);
			model.addAttribute("message", signUpMessage);

			return "sign-up";
		}

		// Login submit
		@PostMapping("sign-up/submit")
		public String signUpSubmit(@RequestParam(value = "username") String username,
				@RequestParam(value = "email") String email, @RequestParam(value = "password1") String password1,
				@RequestParam(value = "password2") String password2, @RequestParam(value = "name") String name,
				Model model) {

			List<User> users = userRepo.findAll();

			for (User u : users) {
				if (u.getUsername().equals(username)) {
					signUpMessage = "Username already exists. Please choose another.";
					model.addAttribute("loggedin", loggedIn);
					model.addAttribute("message", signUpMessage);
					return "redirect:/sign-up";
				}
				if (u.getEmail().equals(email)) {
					signUpMessage = "Email already exists. Please choose another.";
					model.addAttribute("loggedin", loggedIn);
					model.addAttribute("message", signUpMessage);
					return "redirect:/sign-up";
				}

			}

			if (!password1.equals(password2)) {
				signUpMessage = "Passwords did not match. Please try again.";
				model.addAttribute("loggedin", loggedIn);
				model.addAttribute("message", signUpMessage);
				return "redirect:/sign-up";
			} else {
				// make it so the email has to match a regex too
				User user = new User(username, email, password1, name);
				userRepo.save(user);
				session.setAttribute("user", user);
				loggedIn = true;
				infoMessage = "Sign up was successful!";
				return "redirect:/user-info";

			}
		}

		// Add user page
		@RequestMapping("/add")
		public String addTask(

				Model model) {

			User user = (User) session.getAttribute("user");
			

			model.addAttribute("user", user);
			model.addAttribute("loggedin", loggedIn);

			if (loggedIn == true) {
				return "add";
			} else {
				return "redirect:/login";
			}

		}

		// User info page
		@RequestMapping("/user-info")
		public String userSettings(Model model) {

			User user = (User) session.getAttribute("user");
			String hiddenPass = "";

			// redirect to login if not logged in
			if (user == null) {
				return "redirect:/login";
			}

			for (int i = 0; i < user.getPassword().length(); i++) {
				hiddenPass += "*";
			}

			model.addAttribute("user", user);
			model.addAttribute("loggedin", loggedIn);
			model.addAttribute("password", hiddenPass);
			model.addAttribute("message", infoMessage);

			return "user-info";
		}

		// Edit user page
		@RequestMapping("/user/edit")
		public String editUser(Model model) {

			User user = (User) session.getAttribute("user");

			// redirect to login if not logged in
			if (user == null) {
				return "redirect:/login";
			}

			model.addAttribute("user", user);
			model.addAttribute("loggedin", loggedIn);
			model.addAttribute("message", editMessage);

			return "edit-user";
		}

		// Submit changes to user
		@PostMapping("/user/edit/submit")
		public String edit(@RequestParam(value = "userid") Long userId, @RequestParam(value = "username") String username,
				@RequestParam(value = "email") String email, @RequestParam(value = "password1") String password1,
				@RequestParam(value = "password2") String password2, @RequestParam(value = "name") String name,
				Model model) {

			List<User> users = userRepo.findAll();
			User us = (User) session.getAttribute("user");
			User user = userRepo.findByUsername(us.getUsername()); // unnecessary steps - fix

			for (User u : users) {
				if (u.getUsername().equals(username) && u.getId() != user.getId()) {
					editMessage = "New username is unavailable. Please choose another.";
					model.addAttribute("user", user);
					model.addAttribute("loggedin", loggedIn);
					model.addAttribute("message", infoMessage);
					return "redirect:/user/edit";
				}
			}

			if (!password1.equals(password2)) {
				editMessage = "Passwords did not match. Please try again.";
				model.addAttribute("user", user);
				model.addAttribute("loggedin", loggedIn);
				model.addAttribute("message", editMessage);
				return "redirect:/user/edit";
			} else {
				// make it so the email has to match a regex too
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password1);
				user.setName(name);
				userRepo.save(user);
				session.setAttribute("user", user);
				loggedIn = true;
				infoMessage = "Information was successfully edited.";
				return "redirect:/user-info";

			}
			
			
		}
		
		
		
	//Extra methods

	
	
	public void checkLogin() {
		User user = (User)session.getAttribute("user");
		
		if (user == null) {
			loggedIn = false;
		} else {
			loggedIn = true;
		}
		
	}
	
	
	
}
