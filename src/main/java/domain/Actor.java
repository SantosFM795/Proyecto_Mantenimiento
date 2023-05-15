package domain;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)

public abstract class Actor extends DomainEntity{

	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String postalCode;
	private String city;
	private String country;
	
	private UserAccount userAccount;
	
	
	private Collection<Annotation> annotation;
	
	
	@OneToMany
	public Collection<Annotation> getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Collection<Annotation> annotation) {
		this.annotation = annotation;
	}
	
	@NotNull
	@Valid
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}
	
	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount=userAccount;
	}

	@NotBlank
	public String getName() {
		return name;
	}
	
	@NotBlank
	public String getLastName() {
		return lastName;
	}
	
	@NotBlank
	@Email
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(final String email) {
		this.email = email;
	}
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}
	public void setCity(final String city) {
		this.city = city;
	}
	public void setCountry(final String country) {
		this.country = country;
	}
}
