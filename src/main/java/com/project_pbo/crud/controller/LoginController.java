package com.project_pbo.crud.controller;

import com.project_pbo.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String confirmPassword,
                            Model model) {

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            model.addAttribute("registerError", "Username dan password wajib diisi");
            return "login";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("registerError", "Password dan konfirmasi password tidak cocok");
            return "login";
        }

        if (password.length() < 6) {
            model.addAttribute("registerError", "Password minimal 6 karakter");
            return "login";
        }

        UserService.RegisterResult result = userService.registerNewUser(username, password);

        if (result == UserService.RegisterResult.USERNAME_TAKEN) {
            model.addAttribute("registerError", "Username sudah terdaftar, silakan pilih username lain");
            return "login";
        }

        return "redirect:/login?registered=true";
    }
}