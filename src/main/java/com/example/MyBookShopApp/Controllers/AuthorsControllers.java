package com.example.MyBookShopApp.Controllers;

import com.example.MyBookShopApp.Data.Author;
import com.example.MyBookShopApp.Data.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorsControllers {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsControllers(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap(){
        return authorsService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage(Model model){
        return "authors/index";
    }
}
