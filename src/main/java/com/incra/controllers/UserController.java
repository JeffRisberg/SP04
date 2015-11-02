package com.incra.controllers;

import com.incra.models.Box;
import com.incra.models.Site;
import com.incra.models.User;
import com.incra.services.PageFrameworkService;
import com.incra.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The <i>UserController</i> handles all crud operations on users.
 *
 * @author Jeffrey Risberg
 * @since 11/25/11
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PageFrameworkService pageFrameworkService;

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) throws Exception {
        dataBinder.registerCustomEditor
                (Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"), false));
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findEntityList();

        model.addAttribute("user", new User());
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/show/{userId}", method = RequestMethod.GET)
    public String showUser(@PathVariable("userId") int userId, Model model) {

        User user = userService.findEntityById(userId);

        if (user != null) {
            model.addAttribute(user);
            return "user/show";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id) {

        User user = userService.findEntityById(id);

        ModelAndView modelAndView = new ModelAndView("user/edit");
        modelAndView.addObject("command", user);

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {

        userService.save(user);

        try {
            if (user.getDateCreated() == null) user.setDateCreated(new Date());
            user.setLastUpdated(new Date());

            userService.save(user);
        } catch (RuntimeException re) {
            pageFrameworkService.setFlashMessage(session, re.getMessage());
            pageFrameworkService.setIsRedirect(session, Boolean.TRUE);
            return "redirect:/site/list";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, HttpSession session) {

        User user = userService.findEntityById(id);
        if (user != null) {
            try {
                userService.delete(user);
            } catch (RuntimeException re) {
                pageFrameworkService.setFlashMessage(session, re.getMessage());
                pageFrameworkService.setIsRedirect(session, Boolean.TRUE);
                return "redirect:/user/show/" + id;
            }
        } else {
            pageFrameworkService.setFlashMessage(session, "No User with that id");
            pageFrameworkService.setIsRedirect(session, Boolean.TRUE);
        }
        return "redirect:/";
    }
}
