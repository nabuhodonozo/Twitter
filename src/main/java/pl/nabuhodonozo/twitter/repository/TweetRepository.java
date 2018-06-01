package pl.nabuhodonozo.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.nabuhodonozo.twitter.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
