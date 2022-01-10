package br.com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.springboot.models.Admin;
import br.com.springboot.service.AdminsRepo;

@Controller
public class AdminsController {

    @Autowired
    private AdminsRepo repo;

    @GetMapping("/admin")
    public String index(Model model) {

        List<Admin> admins = (List<Admin>) repo.findAll();
        model.addAttribute("admins", admins);

        return "admin/index";
    }

    @GetMapping("/admin/new")
    public String newAdmin() {

        return "admin/new";
    }

    @PostMapping("/admin/create")
    public String createAdmin(Admin admin) {

        repo.save(admin);

        return "redirect:/admin";    
    }
    
}
