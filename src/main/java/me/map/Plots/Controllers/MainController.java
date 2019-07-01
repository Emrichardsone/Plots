package me.map.Plots.Controllers;

import me.map.Plots.models.MapStory;
import me.map.Plots.models.MyUserPrincipal;
import me.map.Plots.models.dao.MapStoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Autowired
    MapStoryDao mapStoryDao;

    @RequestMapping("/")
    public String mainPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }
        model.addAttribute("username", username);
        Iterable<MapStory> story = mapStoryDao.findAll();
        model.addAttribute("story", story);

        return "index";
    }
}


