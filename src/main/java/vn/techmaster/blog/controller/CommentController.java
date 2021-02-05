package vn.techmaster.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.security.CookieManager;
import vn.techmaster.blog.service.CommentService;
import vn.techmaster.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    private CookieManager cookieManager;

    @Autowired
    private PostController postController;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public String editComment(Model model, HttpServletRequest request,
                              @ModelAttribute(name="comment") Comment comment,
                              @RequestParam(required = false) Long id){
        User user = postController.getUser(request);
        model.addAttribute("comment", comment);
        return "editcomment";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute(name="comment") Comment comment,
                             @RequestParam(name="post_id") Long post_id,
                             HttpServletRequest request){
        System.out.println(post_id);
        comment.setCommenter(postController.getUser(request));
        comment.setPost(postService.findById(post_id));
        commentService.save(comment);
        return "redirect:/posts";
    }

    @GetMapping("/delete")
    public String deleteComment(@RequestParam(name="id") Long id){
        commentService.delete(id);
        return "redirect:/posts";
    }
}
