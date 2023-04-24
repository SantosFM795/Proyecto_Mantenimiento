package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.PROPERTY)
public class Trainer extends Actor{
	private CV curriculum;
	private Collection<Activity> activities;
	private Collection<Client> clients;
	
	@ManyToMany
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	@ManyToMany
	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

	@OneToOne(optional=false)
	public CV getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(CV curriculum) {
		this.curriculum = curriculum;
	}
}
