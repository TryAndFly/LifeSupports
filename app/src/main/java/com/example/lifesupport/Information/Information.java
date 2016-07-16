package com.example.lifesupport.Information;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Information  {
    private int id;
    private int image_id;
    private String title;
    private String text;

    public Information(int id, int image_id, String title, String text) {
        this.id = id;
        this.image_id = image_id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}