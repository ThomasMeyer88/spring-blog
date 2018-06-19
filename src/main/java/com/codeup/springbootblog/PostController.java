package com.codeup.springbootblog;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.codeup.springbootblog.services.PostService;


@Controller
public class PostController {

    PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model){
        model.addAttribute("post", postService.getPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "View post creation form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postPostCreate() {
        return "posts a created post";
    }
}
