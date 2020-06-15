package co.grandcircus.FinalProject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.FinalProject.Gamification.ChallengeDao;
import co.grandcircus.FinalProject.Gamification.ChallengeListDao;
import co.grandcircus.FinalProject.User.User;

//test controller: made as a template to be implemented across app

@Controller
public class GameController {
	
	@Autowired ChallengeDao Challenge;
	@Autowired ChallengeListDao ChallengeList;
	@Autowired private HttpSession session;

	@RequestMapping("/challenge-form")
	public String challengeForm(Model model) {
		
		List<co.grandcircus.FinalProject.Gamification.Challenge> challenge;
		
		User user;
		
		user=(User)session.getAttribute("user");
	 
		if(user != null) {
		
		challenge = Challenge.findChallengeByUserId(user.getId());
		int points = 0;
		for(int i =0; i < challenge.size(); i++)
		{points = points + challenge.get(i).getPoints();
		System.out.print(points);
		}
		}
		
	return "challenge-form";
	}
	
	
	
	
	
	
	
	
}
