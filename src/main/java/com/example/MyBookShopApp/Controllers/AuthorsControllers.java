package com.example.MyBookShopApp.Controllers;

import com.example.MyBookShopApp.Data.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class AuthorsControllers {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsControllers(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/authors")
    public String authorsPage(Model model){
        model.addAttribute("authorList", authorsService.getAuthorsData());
        return "authors/index";
    }
}
