package com.example.task_management.Model;

public class Category {

    private String  title;
private int id;
    public Category(int id, String title) {
        this.id = Integer.parseInt(String.valueOf(id));
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
