package com.codeup.springbootblog;



import com.codeup.springbootblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codeup.springbootblog.services.PostService;
import com.codeup.springbootblog.repositories.PostRepository;



@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postService.getPostRepository().findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/create")
    public String postCreate(Model view) {
        Post post = new Post(" ", " ");
        view.addAttribute("post", post);
        return "/posts/create";
    }

    @PostMapping("posts/create")
    public String postCreated(Post post){
        postService.getPostRepository().save(post);
        return "redirect:/posts";

    }

    @GetMapping("posts/edit/{id}")
    public String postEdit(@PathVariable long id, Model view){
        Post post = postService.getPostRepository().findOne(id);
        view.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String postEdited(Post post){
        postService.getPostRepository().save(post);
        return "redirect:/posts";
    }

    @PostMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id, Post post){
        postService.getPostRepository().delete(id);
        return "redirect:/posts";
    }


}
