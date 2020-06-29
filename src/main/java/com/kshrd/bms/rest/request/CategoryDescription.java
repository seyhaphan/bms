package com.kshrd.bms.rest.request;

public class CategoryDescription {
    String name;

    public CategoryDescription() {
    }

    public CategoryDescription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
