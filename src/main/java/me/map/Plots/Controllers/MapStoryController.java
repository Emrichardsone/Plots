package me.map.Plots.Controllers;

import me.map.Plots.models.MapStory;
import me.map.Plots.models.MyUserPrincipal;
import me.map.Plots.models.PlotPoint;
import me.map.Plots.models.User;
import me.map.Plots.models.dao.MapStoryDao;
import me.map.Plots.models.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "mapstory")
public class MapStoryController {

    @Autowired
    MapStoryDao mapStoryDao;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMapForm(Model model, HttpServletRequest req,
                             HttpServletResponse res) {
        model.addAttribute("user", new User());
        model.addAttribute("newMapStory", new MapStory());
        HttpSession mySession = req.getSession();
        model.addAttribute("session");
        return "addmapstory";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addMapFromForm(
            @ModelAttribute @Valid MapStory newMapStory, Errors errors, @ModelAttribute PlotPoint plotPoint,

            Model model)
    {
        model.addAttribute("newMapStory", newMapStory);
        model.addAttribute("lat", newMapStory.getLat());
        model.addAttribute("lng", newMapStory.getLng());
        model.addAttribute("plotPoint", new PlotPoint());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);
        newMapStory.setUser(user);
        mapStoryDao.save(newMapStory);

        return "viewmapstory";
    }

}

