package pl.nabuhodonozo.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.nabuhodonozo.twitter.entity.User;

public interface UserRepository	extends JpaRepository<User, Long> {
	User findByLoginOrEmail(String login, String email);
	User findByLogin(String login);
	User findByEmail(String email);
}
