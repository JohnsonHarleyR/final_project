package co.grandcircus.FinalProject.Favorites;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AffirmationDao extends JpaRepository<FavAffirmation, Long> {
	
	List<FavAffirmation> findByUserId (long id);
	//List<FavAffirmation> findByDate (Date date);
}
