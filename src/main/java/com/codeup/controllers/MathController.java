package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Irby on 2/7/17.
 */
@Controller
public class MathController {
    @GetMapping("/add/{number}/and/{number2}")
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int number2) {
        return number + " + " + number2 + " = " + (number +  number2);
    }
    @GetMapping("/subtract/{number}/and/{number2}")
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int number2) {
        return number + " + " + number2 + " = " + (number -  number2);
    }
    @GetMapping("/multiply/{number}/and/{number2}")
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int number2) {
        return number + " + " + number2 + " = " + (number * number2);
    }
    @GetMapping("/divide/{number}/and/{number2}")
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int number2) {
        return number + " + " + number2 + " = " + (number / number2);
    }
}

