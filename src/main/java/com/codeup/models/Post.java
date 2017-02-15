package com.codeup.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Irby on 2/8/17.
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Title cannot be empty")
    private String blogPostTitle;

    @Column(nullable = false)
    @NotBlank(message = "Description can not be empty")
    @Size(min = 5, message = "Description must have at least 5 characters")
    private String blogPostContent;

    @ManyToOne
    @JoinColumn(name = "post_id") // defined at the table level
    private User user; // owner, author, etc.

    public Post(String blogPostTitle, String blogPostContent) {
        this.blogPostTitle = blogPostTitle;
        this.blogPostContent = blogPostContent;
    }
    public Post(){

    }

    public String getBlogPostTitle() {
        return blogPostTitle;
    }

    public void setBlogPostTitle(String blogPostTitle) {
        this.blogPostTitle = blogPostTitle;
    }

    public String getBlogPostContent() {
        return blogPostContent;
    }

    public void setBlogPostContent(String blogPostContent) {
        this.blogPostContent = blogPostContent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public  User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }
}
