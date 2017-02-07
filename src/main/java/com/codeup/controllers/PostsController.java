package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Irby on 2/7/17.
 */

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "Posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsWithId() {
        return "View an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsFormView() {
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreateNew() {
        return "Create a new post";
    }
}
