package me.map.Plots.models.forms;

import me.map.Plots.models.PlotPoint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlotPointForm {

private PlotPoint plotPoint;

private double lat;

private double lng;

@NotNull
@Size(min=1, message="Give this Plot Point a title!")
private String plotPointTitle;

@NotNull
@Size(min=2, message="Tell us what happened at this Plot Point!")
private String plotStory;

    public PlotPointForm() {
    }

    public PlotPointForm(PlotPoint plotPoint, double lat, double lng, String plotPointTitle, String plotStory) {
        this.plotPoint = plotPoint;
        this.lat = lat;
        this.lng = lng;
        this.plotPointTitle = plotPointTitle;
        this.plotStory = plotStory;
    }

    public PlotPoint getPlotPoint() {
        return plotPoint;
    }

    public void setPlotPoint(PlotPoint plotPoint) {
        this.plotPoint = plotPoint;
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
}
