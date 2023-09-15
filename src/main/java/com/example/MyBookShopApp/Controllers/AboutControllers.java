package com.example.MyBookShopApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutControllers {

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

}
