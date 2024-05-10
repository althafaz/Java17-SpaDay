package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {

    private static List<User> usersList = new ArrayList<>();

    @RequestMapping("/")
    public String getAllUsers(Model model){
        model.addAttribute("users",usersList);
        return "user/index";
    }
    @RequestMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String confirmPassword) {

        if(user.getPassword().equals(confirmPassword)) {
            usersList.add(user);
            return "redirect:";
        }

        else{
            String error = "Password confirmation is failed";
            String userName = user.getUserName();
            String email = user.getEmail();
            model.addAttribute("error",error);
            model.addAttribute("userName",userName);
            model.addAttribute("email",email);
            return "user/add";
        }
    }
}
