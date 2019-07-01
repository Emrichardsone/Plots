package me.map.Plots.Controllers;

import me.map.Plots.models.MapStory;
import me.map.Plots.models.User;
import me.map.Plots.models.UserForm;
import me.map.Plots.models.dao.MapStoryDao;
import me.map.Plots.models.dao.UserRepository;
import me.map.Plots.models.forms.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import javax.validation.Valid;

//@Controller
//@RequestMapping(value = "")
//public class HomeController {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    MapStoryDao mapStoryDao;
//
//    @RequestMapping(value = "")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping(value = "signup", method = RequestMethod.GET)
//    public String regForm(Model model) {
//        model.addAttribute("user", new User());
//        User user=new User();
//        model.addAttribute("userForm", new UserForm());
//        SignupForm signupForm= new SignupForm();
//        return "user/signup";
//    }
//
//    @RequestMapping(value = "signup", method = RequestMethod.POST)
//    public String showReg(@ModelAttribute @Valid UserForm newUserForm, Errors errors, Model model) {
//        model.addAttribute("newMapStory", new MapStory());
//        model.addAttribute("user", new User());
////        model.addAttribute(new SignupForm());
//
//
//        if (!newUserForm.ismatching()){
//            return "user/signup";
//
//        }
//        else {
//            userRepository.save(newUserForm.getUser());
//            return "redirect:mapstory";
//        }
//
//    }
//
//
//    @RequestMapping (value="login")
//    public String login(Model model){
//        return "login";
//    }
//    @RequestMapping (value="login", method=RequestMethod.POST)
//    public String postLogin (Errors errors){
//        return "redirect:mapstory";
////    }
//
//}



