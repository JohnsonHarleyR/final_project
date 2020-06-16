package co.grandcircus.FinalProject.Favorites;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDao extends JpaRepository<FavExercises, Long> {
	
	List<FavExercises> findByUserId (long id);
	//List<FavAffirmation> findByDate (Date date);

}
