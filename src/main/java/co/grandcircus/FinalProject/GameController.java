package co.grandcircus.FinalProject;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.FinalProject.Gamification.ChallengeDao;
import co.grandcircus.FinalProject.Gamification.ChallengeList;
import co.grandcircus.FinalProject.Gamification.ChallengeListDao;
import co.grandcircus.FinalProject.User.User;

//test controller: made as a template to be implemented across app

@Controller
public class GameController {
	
	@Autowired ChallengeDao ChallengeRepo;
	@Autowired ChallengeListDao ChallengeListRepo;
	@Autowired private HttpSession session;

	@RequestMapping("/challenge-form")
	public String challengeForm(Model model) {
		
		
		List<co.grandcircus.FinalProject.Gamification.Challenge> challenge;
		
		User user;
		
		user=(User)session.getAttribute("user");
	    //adds total points of users accomplishments
		if(user != null) {
		
		challenge = ChallengeRepo.findChallengeByUserId(user.getId());
		int points = 0;
		for(int i =0; i < challenge.size(); i++)
		{points = points + challenge.get(i).getPoints();
		System.out.print(points);
		}
		}
		
	return "challenge-form";
	}
	
	@RequestMapping("/submit-challenge")
	public String submitChallenge(@RequestParam (value="category") String category,@RequestParam (value="date") Date date, 
			@RequestParam(value = "description")String description, @RequestParam (value="experationDate") Date experation,
			@RequestParam(value="name")String name, @RequestParam(value = "points_req") Long points_req, 
			@RequestParam(value = "prize_url")String prize_url, Model model){
		    User user;
		    user=(User)session.getAttribute("user");
		    Long user_id = user.getId(); 
		
		    ChallengeList challengeList = null;
		    
		    challengeList.setCategory(category); //Create Count
		    challengeList.setDate(date);//date
		    challengeList.setDescription(description);Created Account
		    challengeList.setExperationDate(experation);
		    challengeList.setName(name);Create Account
		    challengeList.setPointsReq(points_req);//5
		    challengeList.setPrizeUrl(prize_url);//
		    challengeList.setUser(user);//session 
		    
		    ChallengeListRepo.save(challengeList);
		    
		
		return "redirect:challenge-form";
	}

}
