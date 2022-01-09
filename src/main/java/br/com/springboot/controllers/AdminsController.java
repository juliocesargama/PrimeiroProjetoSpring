package br.com.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminsController {

    @GetMapping("/admin")
    public String index() {

        return "admin/index";
    }
    
}
