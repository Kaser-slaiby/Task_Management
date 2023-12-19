package com.example.task_management;

public class Gategory_Model {
    private int id;

    private String GategoryName;

    public Gategory_Model( String gategoryName){
        this.GategoryName = gategoryName;

    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

//    public String getGategoryName() {return GategoryName};
}
