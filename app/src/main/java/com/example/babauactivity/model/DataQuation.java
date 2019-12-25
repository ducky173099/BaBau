package com.example.babauactivity.model;

public class DataQuation {
    private int id;
    private String content;
    private String name;
    private int status;

    public DataQuation(int id, String content, String name, int status) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
