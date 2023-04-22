package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	private Annotation annotations;
	
	@OneToMany
	public Annotation getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Annotation annotations) {
		this.annotations = annotations;
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
