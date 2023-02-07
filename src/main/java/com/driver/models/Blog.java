package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="blog")
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String  content;

    @CreationTimestamp
    private Date pubDate;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Blog(){

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn
    public User user;


    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> imageList;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}