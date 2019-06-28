package me.map.Plots.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlotPoint {

    @Id
    @GeneratedValue
    private int plotPointId;

    private double lat;

    private double lng;

    private String plotPointTitle;

    private String plotStory;

    @JsonIgnore
    @ManyToOne
    private MapStory mapStory;

    public PlotPoint(){}


    public PlotPoint(int plotPointId, double lat, double lng, String plotPointTitle, String plotStory, MapStory mapStory) {
        this.plotPointId = plotPointId;
        this.lat = lat;
        this.lng = lng;
        this.plotPointTitle = plotPointTitle;
        this.plotStory = plotStory;
        this.mapStory = mapStory;
    }

    public int getPlotPointId() {
        return plotPointId;
    }

    public void setPlotPointId(int plotPointId) {
        this.plotPointId = plotPointId;
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

    public String getPlotPointTitle() {
        return plotPointTitle;
    }

    public void setPlotPointTitle(String plotPointTitle) {
        this.plotPointTitle = plotPointTitle;
    }

    public String getPlotStory() {
        return plotStory;
    }

    public void setPlotStory(String plotStory) {
        this.plotStory = plotStory;
    }

    public MapStory getMapStory() {
        return mapStory;
    }

    public void setMapStory(MapStory mapStory) {
        this.mapStory = mapStory;
    }
}
