package domain;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)

public class CV extends DomainEntity{
	private String nameCV;
	private String skills;
	private String formation;
	private String workExperience;
	
	/*
	private Collection<SocialMedia> rrss;
	private Trainer entrenador;
	
	
	@OneToMany
	public Collection<SocialMedia> getRrss() {
		return rrss;
	}

	public void setRrss(Collection<SocialMedia> rrss) {
		this.rrss = rrss;
	}*/

	//no se como funciona los derivados
	public String getName() {
		return nameCV;
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
		this.nameCV = name;
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
