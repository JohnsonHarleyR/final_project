package co.grandcircus.FinalProject.Gamification;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.grandcircus.FinalProject.User.User;

@Entity
@Table (name="challengelist")
public class ChallengeList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long challengeListId;
	private String name;
	private String description;
	private Long pointsReq;
	private Date date;
	private Date experationDate;
	private String category;
	private String prizeUrl;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public ChallengeList() {
		
	}

	public Long getChallengeListId() {
		return challengeListId;
	}

	public void setChallengeListId(Long challengeListId) {
		this.challengeListId = challengeListId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPointsReq() {
		return pointsReq;
	}

	public void setPointsReq(Long pointsReq) {
		this.pointsReq = pointsReq;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getExperationDate() {
		return experationDate;
	}

	public void setExperationDate(Date experation) {
		this.experationDate = experation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrizeUrl() {
		return prizeUrl;
	}

	public void setPrizeUrl(String prizeUrl) {
		this.prizeUrl = prizeUrl;
	}

}
