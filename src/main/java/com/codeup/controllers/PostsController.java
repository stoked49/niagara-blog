package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.PostsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irby on 2/7/17.
 */

@Controller
public class PostsController {

    @Autowired
    PostsRepository postsDao;

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        // array list with several Post objects
//        List<Post> posts = new ArrayList<>();

//        posts.add(new Post("My first post", "body of the first post"));
//        posts.add(new Post("My second post", "body of the second post, so good"));

        // pass the list to the view (through a view model)
        viewModel.addAttribute("posts", postsDao.findAll());
        return "posts/index"; // should return models/index.html
    }

    @GetMapping("/posts/{id}")
    public String viewSinglePost(@PathVariable long id, Model viewModel) {
        // Inside the method that shows an individual post, create a new post object and pass it to the view
//        Post post = new Post("Hello World", "World Body");
        // Pass the Post to the view (through a view model))
        viewModel.addAttribute("post", postsDao.findOne(id));
        return "/posts/show"; // show.html
    }

    @GetMapping("/posts/{id}/edit")
    public String editSinglePost(@PathVariable long id, @ModelAttribute Post post, Model viewModel) {
        viewModel.addAttribute("post", postsDao.findOne(id));
        return "posts/edit";
    }

    @GetMapping("/posts/create")
    public String postsFormView(@ModelAttribute Post post, Model viewModel) {

        viewModel.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreateNew(@Valid Post post, Model viewModel) {
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }
    @PostMapping("/posts/{id}edit")
    public String postsUpdate(@ModelAttribute Post post, Model viewModel) {
        postsDao.save(post);
        viewModel.addAttribute("post", post);
        return "redirect:/posts"; // show.html
    }
    @PostMapping("/posts/delete")
    public String postsDelete(@ModelAttribute Post post) {
        postsDao.delete(postsDao.findOne(post.getId()));
        return "redirect:/posts";
    }
}


