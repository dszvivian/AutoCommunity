package com.example.autocommunity.model;

public class EventInfoModel {

    private double lat;
    private double lon;
    private String placeName;
    private String agenda;
    private int coverImage;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public EventInfoModel(double lat, double lon, String placeName, String agenda,int coverImage) {
        this.lat = lat;
        this.lon = lon;
        this.placeName = placeName;
        this.agenda = agenda;
        this.coverImage = coverImage;
    }
}
