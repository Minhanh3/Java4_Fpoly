package com.example.Session6_Map_Table.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Videos")
public class Videos {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Views")
    private Integer views;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getViews() {
        return this.views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
