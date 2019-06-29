package me.map.Plots.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class MapStory {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String plotLocation;

    @NotNull
    private String mapStoryTitle;


    @JsonIgnore
    @ManyToOne
    private User user;


    @OneToMany(fetch=FetchType.EAGER, mappedBy = "mapStory")
    private List<PlotPoint> points;

    public MapStory(){
    }

    public MapStory(String plotLocation, String mapStoryTitle) {
        this.plotLocation = plotLocation;
        this.mapStoryTitle = mapStoryTitle;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlotLocation() {
        return plotLocation;
    }

    public void setPlotLocation(String plotLocation) {
        this.plotLocation = plotLocation;
    }

    public String getMapStoryTitle() {
        return mapStoryTitle;
    }

    public void setMapStoryTitle(String mapStoryTitle) {
        this.mapStoryTitle = mapStoryTitle;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    public void setPoints(List<PlotPoint> points) {
        this.points = points;
    }

    public List<PlotPoint> getPoints() {
        return points;
    }
}
