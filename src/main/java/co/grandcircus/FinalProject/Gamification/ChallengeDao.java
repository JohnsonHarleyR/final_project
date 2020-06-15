package co.grandcircus.FinalProject.Gamification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.FinalProject.User.User;

public interface ChallengeDao extends JpaRepository <Challenge, Long>{
	
	Challenge findByComplete(boolean complete);
	
	List<Challenge> findChallengeByUserId(Long id);
}
