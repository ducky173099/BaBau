package com.example.babauactivity.model;

public class DataSizebaby {
    private int Hinhseed;
    private String Weeks;
    private String Seeds;
    private String Sizebaby;

    public DataSizebaby(int hinhseed, String weeks, String seeds, String sizebaby) {
        Hinhseed = hinhseed;
        Weeks = weeks;
        Seeds = seeds;
        Sizebaby = sizebaby;
    }

    public int getHinhseed() {
        return Hinhseed;
    }

    public void setHinhseed(int hinhseed) {
        Hinhseed = hinhseed;
    }

    public String getWeeks() {
        return Weeks;
    }

    public void setWeeks(String weeks) {
        Weeks = weeks;
    }

    public String getSeeds() {
        return Seeds;
    }

    public void setSeeds(String seeds) {
        Seeds = seeds;
    }

    public String getSizebaby() {
        return Sizebaby;
    }

    public void setSizebaby(String sizebaby) {
        Sizebaby = sizebaby;
    }
}
