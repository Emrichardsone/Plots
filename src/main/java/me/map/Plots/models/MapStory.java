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

    @NotNull
    private String storyText;

    @JsonIgnore
    @ManyToOne
    private User user;

    @NotNull
    private double lat;

    @NotNull
    private double lng;

    @OneToMany
    @JoinColumn
    private List<PlotPoint> points = new ArrayList<>();

    public MapStory(){
    }

    public MapStory(String plotLocation, String mapStoryTitle) {
        this.plotLocation = plotLocation;
        this.mapStoryTitle = mapStoryTitle;
        this.storyText = storyText;
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

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public List<PlotPoint> getPoints() {
        return points;
    }

    public void setPoints(List<PlotPoint> points) {
        this.points = points;
    }
}
