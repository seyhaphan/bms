package com.kshrd.bms.rest.request;

public class BookRequestModel {
    private String name;
    private String author;
    private String description;
    private String thumbnail;
    private CategoryRequestModel category;

    public BookRequestModel(){}

    public BookRequestModel(String name, String author, String description, String thumbnail, CategoryRequestModel category) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CategoryRequestModel getCategory() {
        return category;
    }

    public void setCategory(CategoryRequestModel category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookRequestModel{" +
                "title='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", category=" + category +
                '}';
    }
}
