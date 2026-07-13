package com.project_pbo.crud.service;

import com.project_pbo.crud.dao.UserDao;
import com.project_pbo.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Dipanggil otomatis oleh Spring Security saat proses login (form /login).
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username tidak ditemukan: " + username));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    public enum RegisterResult { SUCCESS, USERNAME_TAKEN }

    /**
     * Mendaftarkan user baru. Password di-hash dengan BCrypt sebelum disimpan.
     */
    public RegisterResult registerNewUser(String username, String rawPassword) {
        if (userDao.existsByUsername(username)) {
            return RegisterResult.USERNAME_TAKEN;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("USER");
        userDao.save(user);

        return RegisterResult.SUCCESS;
    }
}