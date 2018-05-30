package pl.nabuhodonozo.twitter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@Column(unique = true)
	@Length(min=4, max=12)
	private String login;
	@NotBlank
	@Length(min=8, max=20)
	private String password;
	@Email
	@NotBlank
	@Column(unique = true)
	private String email;
	@NotBlank
	@Length(min=4, max=60)
	private String username;
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Tweet> tweets;
	//name
	//lastname     //those to add and enable editing //crud
	//year of birth
	private boolean enabled = true;

	
	public void setPassword(String password) {
		this.password = password;
	}

	public void hashPassword() {
		this.password = BCrypt.hashpw(this.password, BCrypt.gensalt(5));
	}
	
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
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
//	
	// rozkminic crud dla tweetow
//	public void addTweet(Tweet tweet) {
//		Tweets.add(tweet);
//	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s, enabled=%s]", id, username, password,
				email, enabled);
	}
}
