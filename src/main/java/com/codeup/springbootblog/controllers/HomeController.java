package com.codeup.springbootblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "/minesweeper";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/error")
    @ResponseBody
    public String error(){
        return "You've encountered an error";
    }

    @GetMapping("/ironmind")
    public String ironmind(){
        return "ironmind/IronMind";
    }

}
