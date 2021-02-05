package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllCommentOfPost(Post post) {
        return commentRepository.findByPost(post);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void delete(long id) {
        commentRepository.deleteById(id);
    }
}
