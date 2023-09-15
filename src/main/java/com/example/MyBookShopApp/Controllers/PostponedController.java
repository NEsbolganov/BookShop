package com.example.MyBookShopApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostponedController {

    @GetMapping("/postponed")
    public String postponedController(){
        return "postponed";
    }
}
