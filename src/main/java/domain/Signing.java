package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Signing extends DomainEntity{
	private Date sign_date;
	private Date leaving_date;
	
	private Customer customer;
	private Gym gym;
	
	@Valid
	@ManyToOne(optional=false)
	public Customer getCustomer() {
		return customer;
	}
	
	@Valid
	@ManyToOne(optional=false)
	public Gym getGym() {
		return gym;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setGym(Gym gym) {
		this.gym = gym;
	}
	
	@NotNull
	public Date getSign_date() {
		return sign_date;
	}
	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}
	public Date getLeaving_date() {
		return leaving_date;
	}
	public void setLeaving_date(Date leaving_date) {
		this.leaving_date = leaving_date;
	}
	
	
}
