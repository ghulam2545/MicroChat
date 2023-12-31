package com.ghulam.microchat.service.impl;

import com.ghulam.microchat.exception.CommentNotFoundException;
import com.ghulam.microchat.model.Comment;
import com.ghulam.microchat.model.Post;
import com.ghulam.microchat.model.User;
import com.ghulam.microchat.repository.CommentRepository;
import com.ghulam.microchat.service.CommentService;
import com.ghulam.microchat.service.PostService;
import com.ghulam.microchat.service.UserService;
import com.ghulam.microchat.utils.IdGenerator;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    @Override
    public Comment save(String userId, String postId, Comment comment) {
        final User user = userService.findById(userId);
        final Post post = postService.findById(postId);

        comment.setCommentId(IdGenerator.next());
        comment.setUser(user);
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(String commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("comment not found."));
    }

    @Override
    public Comment update(String commentId, Comment comment) {
        return commentRepository.findById(commentId).map(oldComment -> {

            // update data
            oldComment.setContent(comment.getContent());

            return commentRepository.save(oldComment);
        }).orElseThrow(() -> new CommentNotFoundException("comment not found."));
    }

    @Override
    public void delete(String commentId) {
        commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("comment not found."));

        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findAll() {
        /* todo - implement pagination etc */
        return commentRepository.findAll();
    }

}
