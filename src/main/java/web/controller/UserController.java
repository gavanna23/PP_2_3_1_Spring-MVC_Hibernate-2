package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());
        return "usersTable";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", new User());
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String delete
            (@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PatchMapping("/edit")
    public String edit(@RequestParam("id") long id, User updateUser) {
        userService.updateUser(id, updateUser);
        return "redirect:/";
    }
}
