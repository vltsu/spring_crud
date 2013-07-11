package jettyapp.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import jettyapp.mvc.model.User;
import jettyapp.mvc.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")

public class UserController {
    @Autowired UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/index";
    }



    @RequestMapping(value="/{userId}")
    public String show(@PathVariable String userId, Model model) {
        User user;
        try {
            user = userService.getUserById(Long.parseLong(userId));
        } catch (Exception e) {
            return "404page";
        }
        model.addAttribute("user", user);
        return "users/show";
    }

    @RequestMapping(value="/new")
    public String newUser(Model model) {
        model.addAttribute(new User());
        return "users/new";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return "users/new";
        }
        userService.createUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value="/edit/{userId}", method=RequestMethod.GET)
    public String edit(@PathVariable String userId, Model model) {
        User user;
        try {
            user = userService.getUserById(Long.parseLong(userId));
        } catch (Exception e) {
            return "404page";
        }
        model.addAttribute("user", user);
        return "users/edit";
    }

    @RequestMapping(value="/edit/{userId}", method=RequestMethod.PUT)
    public String update(@PathVariable String userId, @ModelAttribute("user") User user, BindingResult result) {
        try {
            userService.getUserById(Long.parseLong(userId));
        } catch (Exception e) {
            return "404page";
        }

        if(result.hasErrors()){
            return "users/edit/" + userId;
        }

        userService.updateUser(user, Long.parseLong(userId));
        return "redirect:/users/" + userId;
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    public String delete(@PathVariable String userId) {
        try {
            userService.deleteUser(Long.parseLong(userId));
        } catch (Exception e) {
            return "404page";
        }
        return "redirect:/users/";
    }

}