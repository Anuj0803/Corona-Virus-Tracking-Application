package com.Practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HelloController {
    @Autowired
    Services services ;

    @RequestMapping
    public String hello(Model model) {
        model.addAttribute("locationStats" , services.getStats());
        model.addAttribute("DeathStats" , services.getStats2());
        return  "home";
    }
}
