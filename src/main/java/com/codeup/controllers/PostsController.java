package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irby on 2/7/17.
 */

@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        // array list with several Post objects
        List<Post> posts = new ArrayList<>();

//        posts.add(new Post("My first post", "body of the first post"));
//        posts.add(new Post("My second post", "body of the second post, so good"));

        // pass the list to the view (through a view model)
        viewModel.addAttribute("posts", posts);
        return "posts/index"; // should return models/index.html
    }

    @GetMapping("/posts/{id}")
    public String viewSinglePost(@PathVariable long id, Model viewModel) {
        // Inside the method that shows an individual post, create a new post object and pass it to the view
        Post post = new Post("Hello World", "World Body");
        // Pass the Post to the view (through a view model))
        viewModel.addAttribute("post", post);
        return "/posts/show"; // show.html
    }

    @GetMapping("/posts/{id}/edit")
    public String editSinglePost(@ModelAttribute Post post, Model viewModel) {
        viewModel.addAttribute("Message", "");
        return "posts/edit";
    }

    @GetMapping("/posts/create")
    public String postsFormView(Model viewModel) {

        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreateNew(@ModelAttribute Post post, Model viewModel) {
        return "Create a new Post";
    }
}


