package com.poly.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Videos")
public class Video {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(
            name = "title",
            length = 200,
            nullable = false,
            columnDefinition = "NVARCHAR(200)"
    )
    private String title;

    @Column(name = "views")
    private int views;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;

    public Video() {}

    // ===== GETTERS & SETTERS =====
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}
