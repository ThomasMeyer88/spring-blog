package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex() {
        return "Posts Index Page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable float id) {
        return "Posts page number " + id;
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
