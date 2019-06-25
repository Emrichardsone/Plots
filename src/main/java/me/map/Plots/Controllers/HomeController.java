package me.map.Plots.Controllers;

import me.map.Plots.Models.MapStory;
import me.map.Plots.Models.User;
import me.map.Plots.Models.UserForm;
import me.map.Plots.Models.data.MapStoryDao;
import me.map.Plots.Models.data.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "")
public class HomeController {

    @Autowired
    UserDao userDao;

    @Autowired
    MapStoryDao mapStoryDao;

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String regForm(Model model) {
        model.addAttribute("user", new User());
        User user=new User();
        model.addAttribute("userForm", new UserForm());
        UserForm userForm= new UserForm();
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String showReg(@ModelAttribute @Valid UserForm newUserForm, Errors errors, Model model) {
        model.addAttribute("newMapStory", new MapStory());
        model.addAttribute("user", new User());
        model.addAttribute(new UserForm());


        if (!newUserForm.ismatching()){
            return "registration";

        }
        else {
            userDao.save(newUserForm.getUser());
            return "redirect:mapstory";
        }

    }

    @RequestMapping (value="login")
    public String login(Model model){
        return "login";
    }
    @RequestMapping (value="login", method=RequestMethod.POST)
    public String postLogin (Errors errors){
        return "redirect:mapstory";
    }

}



