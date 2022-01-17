package br.com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.springboot.models.Admin;
import br.com.springboot.service.AdminsRepo;

@Controller
public class LoginController {

    @Autowired
    private AdminsRepo repo;

    @GetMapping("/login")
    public String index() {

        return "login/index";
    }
    
    @PostMapping("/validateuser")
    public String login(Model model, Admin admin, String remindMe) {

        Admin adm = this.repo.Login(admin.getEmail(), admin.getPassword());

        if(adm != null){
            return "redirect:/";
        }
        model.addAttribute("error", "Usuário e/ou senha inválidos");
        return "login/index";
    }
}
