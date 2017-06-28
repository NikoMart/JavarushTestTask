package com.javarushTestTask.controllers;

import com.javarushTestTask.model.User;
import com.javarushTestTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUsers(Model model) {
        return "redirect:/page/1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        List<User> listOfUsers = userService.getAllUsers();
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUser(id));
        return "editPage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("user") User user, @RequestParam(value = "id", required = true) Integer id, Model model) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filterUser(@ModelAttribute("user") User user,  Model model) {
        List<User> listOfUsers = userService.filterUsersByName(user.getName());
        model.addAttribute("filter", user.getName());
        model.addAttribute("user", new User());
        model.addAttribute("list", listOfUsers);
        return "userDetails";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String pagination(@PathVariable("pageNumber") int pageNumber, Model model) {
        if (pageNumber<1) return "redirect:/";
        List<User> listOfUsers = userService.getUsers(pageNumber);
        model.addAttribute("pageNumber",pageNumber);
        model.addAttribute("user", new User());
        model.addAttribute("list", listOfUsers);
        return "userDetails";
    }
}