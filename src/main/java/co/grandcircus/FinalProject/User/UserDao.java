package co.grandcircus.FinalProject.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);

}
