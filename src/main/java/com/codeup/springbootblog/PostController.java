package com.codeup.springbootblog;



import com.codeup.springbootblog.models.Post;
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

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        model.addAttribute("post", postService.popPost(id));
        model.addAttribute("id", id);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String postEditPost(@PathVariable long id, Post post){
        post.setId(id);
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String postCreate(Model view) {
        view.addAttribute("post", new Post("",""));
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String postPostCreate(Post post) {
        post.setId(postService.getAllPosts().size()-1);
        postService.savePost(post);
        return "redirect:/posts";
    }
}
