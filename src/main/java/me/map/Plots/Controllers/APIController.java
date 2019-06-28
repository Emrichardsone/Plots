package me.map.Plots.Controllers;

import me.map.Plots.models.MapStory;

import me.map.Plots.models.dao.MapStoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class APIController {

    @Autowired
    private MapStoryDao mapStoryDao;

    @GetMapping("{storyId}")
    public @ResponseBody MapStory getMapStory(@PathVariable int storyId){
        return mapStoryDao.findOne(storyId);

    }




}
