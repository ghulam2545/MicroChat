package com.ghulam.mitter.service.impl;

import com.ghulam.mitter.domain.Comment;
import com.ghulam.mitter.exception.CommentNotFoundException;
import com.ghulam.mitter.repository.CommentRepository;
import com.ghulam.mitter.service.CommentService;
import com.ghulam.mitter.utils.IdGenerator;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final IdGenerator idGenerator;

    public CommentServiceImpl(CommentRepository commentRepository, IdGenerator idGenerator) {
        this.commentRepository = commentRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public Comment save(Comment comment) {
        long id = idGenerator.nextId();
        comment.setId(id + "");
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(String commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("comment not found"));
    }

    @Override
    public Comment update(String commentId, Comment comment) {
        return commentRepository.findById(commentId).map(oldComment -> {

            oldComment.setContent(comment.getContent());
            oldComment.setTimestamp(LocalDateTime.now());

            return commentRepository.save(oldComment);
        }).orElseThrow(() -> new CommentNotFoundException("comment not found"));
    }

    @Override
    public void delete(String commentId) {
        commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("comment not found"));
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findAll() {
        /* todo - implement pagination etc */
        return commentRepository.findAll();
    }
}
