package br.com.springboot.controllers;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.springboot.models.Admin;
import br.com.springboot.service.AdminsRepo;
import br.com.springboot.service.CookieService;

@Controller
public class LoginController {

    @Autowired
    private AdminsRepo repo;

    @GetMapping("/login")
    public String index() {

        return "login/index";
    }
    
    @PostMapping("/validateuser")
    public String login(Model model, Admin admin, String remindUser, HttpServletResponse response) throws UnsupportedEncodingException {

        Admin adm = this.repo.Login(admin.getEmail(), admin.getPassword());

        if(adm != null){

            int logTime = (60 * 60); // 1 hora de cookie

            if(remindUser != null){
                logTime = (60 * 60 * 24 * 365); // 1 ano
            }

            CookieService.setCookie(response, "userId", String.valueOf(adm.getId()), logTime);
            CookieService.setCookie(response, "userName", String.valueOf(adm.getName()), logTime);

            return "redirect:/";
        }
        model.addAttribute("error", "Usuário e/ou senha inválidos");
        return "login/index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) throws UnsupportedEncodingException {

        CookieService.setCookie(response, "userId", "" , 0);
        return "redirect:/login";
    }
}
