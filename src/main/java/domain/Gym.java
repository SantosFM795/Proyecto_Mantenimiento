package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Gym extends DomainEntity{

	private String logo;
	private String name;
	private String address;
	private boolean active;
	private float mensualCost;
	
	private Collection<Annotation> annotation;
	private Collection<Activity> activity;
	private Collection<Signing> signing;
	private Collection<Training> training;
	private Manager manager;
	private Collection<Trainer> trainer;

	@Valid
	@ManyToMany(mappedBy="gyms")
	public Collection<Trainer> getTrainer() {
		return trainer;
	}
	
	public void setTrainer(Collection<Trainer> trainer) {
		this.trainer = trainer;
	}

	@Valid
	@ManyToOne(optional=false)
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@ManyToMany
	public Collection<Training> getTraining() {
		return training;
	}

	public void setTraining(Collection<Training> training) {
		this.training = training;
	}

	
	@OneToMany(mappedBy="gym")
	public Collection<Signing> getSigning() {
		return signing;
	}

	public void setSigning(Collection<Signing> signing) {
		this.signing = signing;
	}

	@OneToMany(cascade=CascadeType.ALL)
	public Collection<Activity> getActivity() {
		return activity;
	}

	public void setActivity(Collection<Activity> activity) {
		this.activity = activity;
	}

	@OneToMany(mappedBy="gym")
	public Collection<Annotation> getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Collection<Annotation> annotation) {
		this.annotation = annotation;
	}

	@URL
	public String getLogo() {
		return logo;
	}
	
	@NotBlank
	public String getName() {
		return name;
	}
	
	@NotBlank
	public String getAddress() {
		return address;
	}
	public boolean isActive() {
		return active;
	}
	public float getMensualCost() {
		return mensualCost;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setMensualCost(float mensualCost) {
		this.mensualCost = mensualCost;
	}
}
