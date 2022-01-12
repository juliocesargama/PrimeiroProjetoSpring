package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/admin/{id}/delete")
    public String deleteAdmin(@PathVariable int id) {

        repo.deleteById(id);

        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}")
    public String seachAdmin(@PathVariable int id, Model model) {

        Optional<Admin> admin = repo.findById(id);
        try {
            model.addAttribute("admin", admin.get());
        } catch (Exception e) {
            return "redirect:/admin";
        }
        return "/admin/edit";
    }

    @PostMapping("/admin/{id}/update")
    public String updateAdmin(@PathVariable int id, Admin admin) {

        if (repo.findById((id)).isPresent()) {
            repo.save(admin);
        }
        return "redirect:/admin";

    }
}
