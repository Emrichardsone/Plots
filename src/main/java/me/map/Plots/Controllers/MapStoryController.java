package me.map.Plots.Controllers;

import me.map.Plots.models.MapStory;
import me.map.Plots.models.MyUserPrincipal;
import me.map.Plots.models.PlotPoint;
import me.map.Plots.models.User;
import me.map.Plots.models.dao.MapStoryDao;
import me.map.Plots.models.dao.PlotPointDao;
import me.map.Plots.models.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping(value = "mapstory")
public class MapStoryController {

    @Autowired
    MapStoryDao mapStoryDao;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlotPointDao plotPointDao;

    @GetMapping("{storyId}")
    public String getStory(@PathVariable int storyId, Model model) {
        MapStory story = mapStoryDao.findOne(storyId);

        model.addAttribute("story", story);

        return "viewmapstory";
    }

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
            Model model) {
        model.addAttribute("newMapStory", newMapStory);
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
        int id=newMapStory.getId();
        model.addAttribute("id", id);

        return "redirect:/mapstory/" + newMapStory.getId() + "/plotpoint/new";
    }

    @RequestMapping(value = "{storyId}/plotpoint/new", method = RequestMethod.GET)
    public String getPlotPointForm(@PathVariable int storyId, Model model) {

        MapStory story = mapStoryDao.findOne(storyId);
        model.addAttribute("mapStory", story);
        PlotPoint pp = new PlotPoint();
        pp.setMapStory(story);
        model.addAttribute("plotPoint", pp);
//        HttpSession mySession = req.getSession();
//        model.addAttribute("session");

        return "plotpoint";
    }

    @RequestMapping(value = "{storyId}/plotpoint/new", method = RequestMethod.POST)
    public String addMapFromForm(
            @PathVariable int storyId,
            @ModelAttribute @Valid PlotPoint newPlotPoint,
            Model model) {
        MapStory story = mapStoryDao.findOne(storyId);
        newPlotPoint.setMapStory(story);
        plotPointDao.save(newPlotPoint);
        model.addAttribute("newPlotPoint", newPlotPoint);

        return "redirect:/mapstory/" + storyId;

    }
}

