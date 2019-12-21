package com.example.babauactivity.model;

public class DataNickName {
    private int id;
    private String Nickname;
    private int isstar;
    private int sex;

    public DataNickName(int id, String nickname, int isstar, int sex) {
        this.id = id;
        Nickname = nickname;
        this.isstar = isstar;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public int getIsstar() {
        return isstar;
    }

    public void setIsstar(int isstar) {
        this.isstar = isstar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
