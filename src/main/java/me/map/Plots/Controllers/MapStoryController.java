package me.map.Plots.Controllers;

import me.map.Plots.Models.MapStory;
import me.map.Plots.Models.User;
import me.map.Plots.Models.data.MapStoryDao;
import me.map.Plots.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="mapstory")
public class MapStoryController {

    @Autowired
    MapStoryDao mapStoryDao;

    @Autowired
    UserDao userDao;

    @RequestMapping (value="", method= RequestMethod.GET)
    public String addMapForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("newMapStory", new MapStory());
        return "addmapstory";
    }
    @RequestMapping (value="", method=RequestMethod.POST)
    public String showNewMap(@ModelAttribute MapStory newMapStory,
                             Errors errors, Model model, @ModelAttribute User newUser){
        System.out.println("got here");
        model.addAttribute("newMapStory", newMapStory);
        User user = userDao.findOne(newUser.getId());
        mapStoryDao.save(newMapStory);
        return "viewmapstory";
    }

}

