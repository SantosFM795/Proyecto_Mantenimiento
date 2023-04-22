package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class SocialMedia extends DomainEntity{

	private String nick;
	private String url;
	private String rrss;
	
	@NotBlank
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	@URL
	@NotBlank
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@NotBlank
	public String getRrss() {
		return rrss;
	}
	public void setRrss(String rrss) {
		this.rrss = rrss;
	}
}
