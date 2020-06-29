package com.kshrd.bms.rest.response;

import com.kshrd.bms.repository.dto.CategoryDto;

public class BookResponseModel {
    private int id;
    private String name;
    private String author;
    private String description;
    private String thumbnail;
    private CategoryDto category;

    public BookResponseModel() {
    }

    public BookResponseModel(int id, String name, String author, String description, String thumbnail, CategoryDto category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", category=" + category +
                '}';
    }
}
