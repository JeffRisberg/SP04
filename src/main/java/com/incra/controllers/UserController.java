package com.incra.controllers;

import com.incra.models.User;
import com.incra.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findEntityList();

        model.addAttribute("user", new User());
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/show/{userId}", method = RequestMethod.GET)
    public String showUser(@PathVariable("userId") int userId, Model model) {

        User user = userService.findEntityById(userId);
        System.out.println(user);
        if (user != null) {
            model.addAttribute(user);
            return "user/show";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {

        userService.save(user);

        return "redirect:/";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {

        userService.delete(userService.findEntityById(userId));

        return "redirect:/";
    }
}
