package ru.javamentor.springmvchibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springmvchibernate.model.Role;
import ru.javamentor.springmvchibernate.model.User;
import ru.javamentor.springmvchibernate.service.RoleServiceImpl;
import ru.javamentor.springmvchibernate.service.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/new")
    public String getUserFormForCreate(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("role", roleService.getAllRole());
        return "new";
    }
    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String getFormForEditUser(Model model, @PathVariable("id") Long id ){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("role", roleService.getAllRole());
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateEditUser(User user){
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
