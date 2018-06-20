package com.codeup.springbootblog.services;


import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {
    private List<Post> posts;

    public PostService(){
        this.posts = new ArrayList<>();
        createPosts();
    }


    public List<Post> getAllPosts(){
        return posts;
    }

    public Post getPost(long id){
        return posts.get((int)(id) - 1);

    }

    public Post popPost(long id){
        Post post = posts.get((int)(id-1));
        posts.remove(posts.get((int)(id-1)));
        return post;

    }

    public void savePost(Post post){
        posts.add(post);

    }

    private void createPosts() {
        posts.add(new Post("Title #1", "Body #1"));
        posts.add(new Post("Title #2", "Body #2"));
        posts.add(new Post("Title #3", "Body #3"));
        posts.add(new Post("Title #4", "Body #4"));
    }
}

//
