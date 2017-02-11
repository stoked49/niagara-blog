package com.codeup.models;

import javax.persistence.*;

/**
 * Created by Irby on 2/8/17.
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String blogPostTitle;

    @Column
    private String blogPostContent;

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
}
