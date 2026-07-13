package com.project_pbo.crud.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GuestController {

    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();

    @GetMapping("/guest-login")
    public String guestLogin(HttpServletRequest request, HttpServletResponse response) {

        // Buat authentication palsu dengan role GUEST, tanpa perlu username/password
        Authentication guestAuth = new UsernamePasswordAuthenticationToken(
                "Tamu",
                null,
                List.of(new SimpleGrantedAuthority("ROLE_GUEST"))
        );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(guestAuth);
        SecurityContextHolder.setContext(context);

        securityContextRepository.saveContext(context, request, response);

        return "redirect:/mahasiswa";
    }
}