package domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Embeddable
@Access(AccessType.PROPERTY)
public class CreditCard {
	private String name;
	private String number;
	private String brand;
	private Integer expirationMonth;
	private Integer expirationYear;
	private Integer cvv;
	private boolean isActive;
	
	@NotBlank
	public String getName() {
		return name;
	}
	
	@CreditCardNumber
	public String getNumber() {
		return number;
	}
	
	@NotBlank
	public String getBrand() {
		return brand;
	}
	
	@NotNull
	@Range(min=1, max=12)
	public Integer getExpirationMonth() {
		return expirationMonth;
	}
	
	@NotNull
	@Digits(integer=2, fraction=0)
	public Integer getExpirationYear() {
		return expirationYear;
	}
	
	@NotNull
	@Range(min=100, max=999)
	public Integer getCvv() {
		return cvv;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
