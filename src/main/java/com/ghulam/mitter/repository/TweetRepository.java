package com.ghulam.mitter.repository;

import com.ghulam.mitter.domain.Tweet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TweetRepository extends JpaRepository<Tweet, String> {
}
