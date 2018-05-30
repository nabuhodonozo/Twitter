package pl.nabuhodonozo.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.nabuhodonozo.twitter.entity.User;

public interface UserRepository	extends JpaRepository<User, Long> {
	User findByUsernameOrEmail(String username, String email);
	User findByUsername(String username);
	User findByEmail(String email);
}
