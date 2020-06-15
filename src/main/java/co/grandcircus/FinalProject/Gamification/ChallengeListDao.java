package co.grandcircus.FinalProject.Gamification;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.FinalProject.User.User;

public interface ChallengeListDao extends JpaRepository <ChallengeList, Long> {
	
	ChallengeList findByUserId(Long userId);

	ChallengeList findByCategory(String category);
}
