package co.grandcircus.FinalProject.Favorites;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordDao extends JpaRepository<Record, Long> {

	List<Record> findByUserId (long id);
	//List<Record> findByDate (Date date);
	
}
