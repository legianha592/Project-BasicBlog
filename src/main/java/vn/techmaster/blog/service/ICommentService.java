package vn.techmaster.blog.service;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllCommentOfPost(Post post);
    Comment save(Comment comment);
    Comment findById(Long id);
    void delete(long id);
}
