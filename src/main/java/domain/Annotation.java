package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Annotation extends DomainEntity{
	
	private Date date_send;
	private String text;
	private Integer rating;
	
	private Gym gym;
	private Training training;
	private Activity activity;
	
	@Valid
	@ManyToOne(optional=true)
	public Gym getGym() {
		return gym;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Training getTraining() {
		return training;
	}
	
	@Valid
	@ManyToOne(optional=true)
	public Activity getActivity() {
		return activity;
	}
	
	public void setGym(Gym gym) {
		this.gym = gym;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	@Past
	@NotNull
	public Date getDate_send() {
		return date_send;
	}
	public void setDate_send(Date date_send) {
		this.date_send = date_send;
	}
	
	@NotBlank
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Range(min=0, max=3)
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
