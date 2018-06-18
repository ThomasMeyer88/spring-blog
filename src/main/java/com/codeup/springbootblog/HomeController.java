package com.codeup.springbootblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "This is the landing page";
    }

    @GetMapping("/error")
    @ResponseBody
    public String error(){
        return "You've encountered an error";
    }



}
