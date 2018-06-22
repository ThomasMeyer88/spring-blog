package com.codeup.springbootblog.models;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 100)
    private String body;

    @Id @GeneratedValue
    private long id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id")
    private User user;

    public Post(){

    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
