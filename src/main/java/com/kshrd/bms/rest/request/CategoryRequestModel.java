package com.kshrd.bms.rest.request;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryRequestModel {

    private int id;
    @JsonIgnore
    private String name;

    public CategoryRequestModel() {
    }

    public CategoryRequestModel(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryRequestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
