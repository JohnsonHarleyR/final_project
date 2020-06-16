package co.grandcircus.FinalProject.DailyQuestions;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyUserQuestionsDao extends JpaRepository<DailyUserQuestions, Long> {

}
