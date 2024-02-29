package com.example.c0823g1_movie_backend.model;

import jakarta.persistence.*;

@Entity
public class MovieHasGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    Movie movie;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    Genre genre;

    public MovieHasGenre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
