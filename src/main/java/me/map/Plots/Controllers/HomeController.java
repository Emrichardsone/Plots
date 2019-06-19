package me.map.Plots.Controllers;

import me.map.Plots.Models.User;
import me.map.Plots.Models.data.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import javax.validation.Valid;

@Controller
@RequestMapping(value="")
    public class HomeController {

        @Autowired UserDao userDao;

        @RequestMapping(value = "")
        public String index() {
            return "index";
        }

        @RequestMapping (value="registration", method= RequestMethod.GET)
            public String regForm(Model model){
                model.addAttribute("user", new User());
                return "registration";
            }
        @RequestMapping (value="registration", method=RequestMethod.POST)
            public String showReg(@ModelAttribute @Valid User newUser, Errors errors, Model model){

                userDao.save(newUser);
                return "testpost";
            }

        }



