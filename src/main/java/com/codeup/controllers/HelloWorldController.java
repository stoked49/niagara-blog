package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irby on 2/7/17.
 */

@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String homePage() {
        return "home"; //home.html
    }



    @GetMapping("/contact")
    public String contactPage() {
        return "contact/form";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return formatGreeting(name);
    }

    private String formatGreeting(String name) {
        return "<h1>Hello " + name + " from Spring!!!!</h1>";
    }

    @RequestMapping(path = "/bye/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String bye(@PathVariable String name) {
        return "<h1>Goodbye " + name + "!  from Spring</h1>";
    }

    @GetMapping("/default")
    public String showDefault(Model model) {

        List<String> names = new ArrayList<>();
        names.add("Pierre");
        names.add("Kevin");
        names.add("Vrod");
        names.add("Papo");

        //Passing all the attributes to my view using the model
        //This is a String
        model.addAttribute("date", "Feb 7th");
        //This is an Integer
        model.addAttribute("age", 26);
        //This is a list
        model.addAttribute("ListNames", names);

        return "contact/default";
    }
}
