package me.map.Plots.Controllers;

import me.map.Plots.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="")
    public class HomeController {

        @RequestMapping(value = "")
        public String index() {
            return "index";
        }

        @RequestMapping (value="registration", method= RequestMethod.GET)
            public String registration(Model model){
                model.addAttribute("user", new User());
                return "registration";
            }
        @RequestMapping (value="registration", method=RequestMethod.POST)
            public String showreg(@ModelAttribute User user){
            return "testpost";
            }

        }



