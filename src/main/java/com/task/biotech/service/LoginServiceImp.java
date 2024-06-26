package com.task.biotech.service;

import com.task.biotech.entity.Login;
import com.task.biotech.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginRepo repo;

    @Override
    public String registration(Login login) {
        if (!login.getUserId().contains("@gmail.com")) {
            return "User ID must contain @gmail.com";
        }

        String password = login.getPassword();
        if (!isValidPassword(password)) {
            return "Password must be at least 8 characters long, contain at least one uppercase letter, one number, and one special character";
        }

        if (!password.equals(login.getConformPass())) {
            return "Password and confirmation password do not match";
        }

        repo.save(login);
        return "Registration successful";
    }

    @Override
    public boolean authenticateUser(String userId, String password) {
        Login user = repo.findByUserId(userId);
        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[!@#$%^&*()].*")) {
            return false;
        }

        return true;
    }
}
