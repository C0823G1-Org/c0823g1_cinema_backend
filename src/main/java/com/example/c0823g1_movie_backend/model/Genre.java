package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted = false;
    @OneToMany(mappedBy = "genre")
    private Set<MovieHasGenre> movies;


    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Set<MovieHasGenre> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieHasGenre> movies) {
        this.movies = movies;
    }
}
