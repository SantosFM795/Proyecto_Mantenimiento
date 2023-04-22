package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Training extends DomainEntity{
	private String title;
	private String description;
	private String[] exercises;
	private Annotation annotations;
	
	@OneToMany
	public Annotation getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Annotation annotations) {
		this.annotations = annotations;
	}
	@NotBlank
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String[] getExercises() {
		return exercises;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setExercises(String[] exercises) {
		this.exercises = exercises;
	}
}
