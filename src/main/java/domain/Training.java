package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Training extends DomainEntity{
	private String title;
	private String description;
	private String[] exercises;
	private Collection<Annotation> annotations;
	private Collection<Step> steps;
	
	@OneToMany(cascade=CascadeType.ALL)
	public Collection<Step> getSteps() {
		return steps;
	}

	public void setSteps(Collection<Step> steps) {
		this.steps = steps;
	}

	@OneToMany(mappedBy="Annotation")
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
