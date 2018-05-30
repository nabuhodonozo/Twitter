package pl.nabuhodonozo.twitter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Column(unique=true)
	@Min(8)
	private String username;
	@NotBlank
	@Min(8)
	private String password;
	@Email
	@NotBlank
	@Column(unique=true)
	private String email;
	private boolean enabled = true;
	
	
	//do form rejestracji zwykly user
	//do logowania rejestracji UserDto
	
	//bo bedzie mial szyfrowane haslo 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt(5));
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s, enabled=%s]", id, username, password,
				email, enabled);
	}
}
