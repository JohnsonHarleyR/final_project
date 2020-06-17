package co.grandcircus.FinalProject.SaveCounter;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveCounterDao extends JpaRepository<SaveCounter, Long> {
	
	List<SaveCounter> findByUserId (long id);
	
}
