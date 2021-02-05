package vn.techmaster.blog.service;

import java.util.List;

import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;

public interface IPostService {
  List<Post> getAllPostOfUser(User user);
  List<Post> getAllPost();

  Post save(Post post);

  Post findById(long id);
  void delete(long id);
}
