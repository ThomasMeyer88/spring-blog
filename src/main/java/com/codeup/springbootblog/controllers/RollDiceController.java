package com.codeup.springbootblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class RollDiceController{

    @GetMapping("/roll-dice")
    public String showGame(){
        return "roll-dice";
    }

    @GetMapping("roll-dice/{number}")
    public String diceRoll(@PathVariable int number, Model model){
        int random = (int) (Math.random()*6+1);
        boolean result = (number == random);
        model.addAttribute("result", result);
        model.addAttribute("random", random);
        return "dice-outcome";
    }



}
