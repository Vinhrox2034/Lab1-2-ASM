package com.poly.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "Users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        }
)
public class User {

    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(
            name = "fullname",
            length = 100,
            nullable = false,
            columnDefinition = "NVARCHAR(100)"
    )
    private String fullname;

    @Column(
            name = "email",
            length = 100,
            nullable = false,
            unique = true,
            columnDefinition = "NVARCHAR(100)"
    )
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    public User() {}

    // ===== GETTERS & SETTERS =====

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }
}
