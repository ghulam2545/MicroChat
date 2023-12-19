package com.ghulam.microchat.service;

import com.ghulam.microchat.model.Comment;
import com.ghulam.microchat.model.Tweet;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.CommentRepository;
import com.ghulam.microchat.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final TweetService tweetService;
    private final IdGenerator idGenerator;

    public Comment save(String userId, String tweetId, Comment comment) {
        // set comment id
        long id = idGenerator.nextId();
        comment.setCommentId(id + "");

        // set user
        User user = userService.findById(userId);
        comment.setUser(user);

        // set tweet
        Tweet tweet = tweetService.findById(tweetId);
        comment.setTweet(tweet);

        return commentRepository.save(comment);
    }

    /*
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     * todo
     */
}
