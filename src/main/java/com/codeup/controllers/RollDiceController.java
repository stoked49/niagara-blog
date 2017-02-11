package com.codeup.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Irby on 2/8/17.
 */

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String showLinksWithNumbers() {
        return"roll-dice/index";
    }
    @GetMapping("/roll-dice/{n}")
    public String compareGuess(@PathVariable int n, Model model) {
        // Generate a random number between 1 and 6
        int rollDice = (int) (Math.random() * 6 + 1);

        model.addAttribute("n");
        model.addAttribute("rollDice", rollDice);
        return "roll-dice/roll-dice-result";
    }
}
