package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{number}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number, @PathVariable int numberTwo) {
        return number + " plus " + numberTwo + " = " + (number+numberTwo);
    }

    @RequestMapping(path = "/subtract/{number}/from/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int number, @PathVariable int numberTwo) {
        return numberTwo + " minus " + number + " = " + (numberTwo-number);
    }

    @RequestMapping(path = "/multiply/{number}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int number, @PathVariable int numberTwo) {
        return number + " times " + numberTwo + " = " + (number*numberTwo);
    }

    @RequestMapping(path = "/divide/{number}/by/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int number, @PathVariable int numberTwo) {
        return number + " divided by " + numberTwo + " = " + (number/numberTwo);
    }
}
