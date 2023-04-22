package domain;

import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)

public class Activity extends DomainEntity{

	private String title;
	private String day;
	private Integer startTime;
	private Integer endTime;
	private Integer availableSpots;
	private String clients;
	private String description;
	private String [] photos;
	private Collection<Annotation> annotations;
	
	
	@OneToMany
	public Collection<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Collection<Annotation> annotations) {
		this.annotations = annotations;
	}

	@NotBlank
	public String getTitle() {
		return title;
	}
	
	public String getDay() {
		return day;
	}
	
	public Integer getStartTime() {
		return startTime;
	}
	
	public Integer getEndTime() {
		return endTime;
	}
	
	public Integer getAvailableSpots() {
		return availableSpots;
	}
	
	@NotBlank
	public String getClients() {
		return clients;
	}
	
	@NotBlank
	public String getDescription() {
		return description;
	}
	
	@URL
	public String[] getPhotos() {
		return photos;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public void setAvailableSpots(Integer availableSpots) {
		this.availableSpots = availableSpots;
	}
	public void setClients(String clients) {
		this.clients = clients;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPhotos(String[] photos) {
		this.photos = photos;
	}
}
