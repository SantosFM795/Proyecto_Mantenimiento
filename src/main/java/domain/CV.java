package domain;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)

public class CV extends DomainEntity{
	private String nameCV;
	private String skills;
	private String formation;
	
	private String workExperience;
	
	
	private Collection<SocialMedia> rrss;
	private Trainer trainer;
	
	@Valid
	@OneToOne(optional=false, mappedBy="curriculum")
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	@OneToMany
	public Collection<SocialMedia> getRrss() {
		return rrss;
	}

	public void setRrss(Collection<SocialMedia> rrss) {
		this.rrss = rrss;
	}
	
	@NotBlank
	@Valid
	@Transient
	public String getName() {
		String result;
		
		if(this.trainer != null)
			result = this.trainer.getName() + " " + this.trainer.getLastName();
		else
			result = this.nameCV;
		
		return result;
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
	public void setName(final String name) {
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
