package com.springboot3mexample.ppspringboot3m1.controller;

import com.springboot3mexample.ppspringboot3m1.model.User;
import com.springboot3mexample.ppspringboot3m1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "/user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/test")
    public ResponseEntity getConnection() {
        try {
            return ResponseEntity.ok("Тестовый ответ!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка: " + e);
        }
    }

}
