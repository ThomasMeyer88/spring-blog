package com.codeup.springbootblog.controllers;



import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.codeup.springbootblog.services.PostService;


@Controller
public class PostController {
    private PostService postService;
    private UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService)
    {
        this.postService = postService;
        this.userService = userService;
    }




    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postService.getPostRepository().findAll());
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String postCreate(Model view) {
        Post post = new Post(" ", " ");
        view.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String postCreated(Post post){
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User poster = userService.getUsers().findById(loggedIn.getId());
        post.setUser(poster);
        postService.getPostRepository().save(post);
        return "redirect:/posts";

    }

    @GetMapping("posts/show/{id}")
    public String showPost(@PathVariable long id, Model view){
        Post post = postService.getPostRepository().findOne(id);
        User user = post.getUser();
        view.addAttribute("post", post);
        view.addAttribute("email", user.getEmail());
        return "posts/show";

    }

    @PostMapping("posts/find/{title}")
    public String postTitle(@PathVariable String title, Model view){
        Post post = postService.getPostRepository().findByTitle(title);
        view.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("posts/edit/{id}")
    public String postEdit(@PathVariable long id, Model view){
        Post post = postService.getPostRepository().findOne(id);
        view.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String postEdited(Post post){
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User poster = userService.getUsers().findById(loggedIn.getId());
        postService.edit(post, poster);
        return "redirect:/posts";
    }

    @PostMapping("posts/delete/{id}")
    public String deletePost(@PathVariable long id, Post post){
        postService.getPostRepository().delete(id);
        return "redirect:/posts";
    }


}
