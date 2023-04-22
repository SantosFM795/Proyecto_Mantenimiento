package domain;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)

public class CV extends DomainEntity{
	private String name;
	private String skills;
	private String formation;
	private String workExperience;
	
	//no se como funciona los derivados
	public String getName() {
		return name;
	}
	
	@NotBlank
	public String getSkills() {
		return skills;
	}
	
	@NotBlank
	public String getFormation() {
		return formation;
	}
	
	@NotBlank
	public String getWorkExperience() {
		return workExperience;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
}
