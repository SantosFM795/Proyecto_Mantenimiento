package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Gym extends DomainEntity{

	private String logo;
	private String nameGym;
	private String address;
	private boolean active;
	private float mensualCost;
	/*
	private Collection<Annotation> annotations;
	private Collection<Activity> activities;
	private Collection<Client> clients;
	private Collection<Training> trainings;
	

	@ManyToMany
	public Collection<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Collection<Training> trainings) {
		this.trainings = trainings;
	}

	
	@OneToMany(mappedBy="Client")
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	@OneToMany(cascade=CascadeType.ALL)
	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

	@OneToMany(mappedBy="Annotation")
	public Collection<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Collection<Annotation> annotations) {
		this.annotations = annotations;
	}*/

	@URL
	public String getLogo() {
		return logo;
	}
	
	@NotBlank
	public String getName() {
		return nameGym;
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
		this.nameGym = name;
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
