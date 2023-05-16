package ru.renicheronte.spring_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.renicheronte.spring_hibernate.model.User;
import ru.renicheronte.spring_hibernate.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "show_user";
    }

    @GetMapping("users/create-new")
    public String createUser(@ModelAttribute("user") User user) {
        return "create_new_user";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit_user";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
