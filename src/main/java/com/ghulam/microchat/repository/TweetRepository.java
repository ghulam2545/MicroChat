package com.ghulam.microchat.repository;

import com.ghulam.microchat.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, String> {
}
