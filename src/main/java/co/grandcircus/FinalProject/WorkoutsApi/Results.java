package co.grandcircus.FinalProject.WorkoutsApi;

import java.util.List;

public class Results {
	private String name;
	private Category category;
	private String description;
	private List <Equipment> equipment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		return "Results [name=" + name + ", description=" + description + "]";
	}
}
