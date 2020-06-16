package co.grandcircus.FinalProject.QuoteApi;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteOfTheDayDao extends JpaRepository<QuoteOfTheDay, Long>{
	List<QuoteOfTheDay> findById (long id);
	List<QuoteOfTheDay> findByDatetime (Date datetime);
}
