package com.poly.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = "Favorites",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userId", "videoId"})
        }
)
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "videoId", nullable = false)
    private Video video;

    @Temporal(TemporalType.DATE)
    @Column(name = "likeDate")
    private Date likeDate;

    public Favorite() {}

    // ===== GETTERS & SETTERS (REQUIRED FOR JSP) =====

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}
