package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "version")
    private Set<MovieHasVersion> movie;

    public Version() {
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

    public Set<MovieHasVersion> getMovie() {
        return movie;
    }

    public void setMovie(Set<MovieHasVersion> movie) {
        this.movie = movie;
    }
}
