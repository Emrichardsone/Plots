package me.map.Plots.Models;

import javax.persistence.*;

@Entity
@Table(name="MapStory")
public class MapStory {

    @Id
    @GeneratedValue
    private int id;

    private String plotLocation;

    private String mapStoryTitle;

    private String plotPoint;

    @ManyToOne
    private User user;

    public MapStory(){
    }

    public MapStory(String plotLocation, String mapStoryTitle) {
        this.plotLocation = plotLocation;
        this.mapStoryTitle = mapStoryTitle;
        this.plotPoint = plotPoint;
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

    public String getPlotPoint() {
        return plotPoint;
    }

    public void setPlotPoint(String plotPoint) {
        this.plotPoint = plotPoint;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }
}
