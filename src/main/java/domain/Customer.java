package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor{
	private CreditCard creditCard;
	
	private Collection<Activity> activities;
	private Collection<Signing> signing;
	
	
	@OneToMany(mappedBy="customer")
	public Collection<Signing> getSigning() {
		return signing;
	}

	public void setSigning(Collection<Signing> signing) {
		this.signing = signing;
	}

	
	
	
	@ManyToMany
	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

		


	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public void quit(Activity activity) {
		this.activities.remove(activity);
		
	}

	public void join(Activity activity) {
		this.activities.add(activity);
		
	}

	public void addSigning(Signing result) {
		this.signing.add(result);
	}
}
