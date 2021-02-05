package vn.techmaster.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.PostRepository;

@Service
public class PostService implements IPostService {

  @Autowired
  private PostRepository postRepository;

  @Override
  public List<Post> getAllPostOfUser(User user) {
    return postRepository.findByAuthor(user);
  }

  @Override
  public Post save(Post post) {
    return postRepository.save(post);
  }

  @Override
  public Post findById(long id) {
    return postRepository.findById(id).get();
  }

  @Override
  public void delete(long id) {
    postRepository.deleteById(id);
  }

  @Override
  public List<Post> getAllPost(){
    return postRepository.findAll();
  }

}
