package me.map.Plots.Controllers;

import me.map.Plots.models.MapStory;
import me.map.Plots.models.MyUserPrincipal;
import me.map.Plots.models.User;
import me.map.Plots.models.dao.MapStoryDao;
import me.map.Plots.models.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    MapStoryDao mapStoryDao;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String mainPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user= userRepository.findByUsername(username);
        model.addAttribute("username", username);
        List<MapStory> storyTwo = mapStoryDao.findByUser(user);
        model.addAttribute("story", storyTwo);

        return "index";
    }
}


