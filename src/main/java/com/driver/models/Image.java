package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setDescription(String description) {
        this.description = description;
    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public Image() {
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDimensions() {
        return dimensions;
    }

    private String description;
    private String dimensions;

    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}