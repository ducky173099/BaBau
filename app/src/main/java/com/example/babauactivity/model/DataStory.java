package com.example.babauactivity.model;

public class DataStory {
    private int id;
    private String DescStory;
    private int status;

    public DataStory(int id, String descStory, int status) {
        this.id = id;
        DescStory = descStory;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescStory() {
        return DescStory;
    }

    public void setDescStory(String descStory) {
        DescStory = descStory;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
