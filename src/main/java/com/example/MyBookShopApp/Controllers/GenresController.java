package com.example.MyBookShopApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class GenresController {

    @GetMapping("/genres")
    public String genresPage(Model model){
        return "genres/index";
    }
}
