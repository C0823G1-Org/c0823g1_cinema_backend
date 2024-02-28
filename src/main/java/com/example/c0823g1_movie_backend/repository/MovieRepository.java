package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(name = "select count(b.account_id),m.name as tenphim\n" +
            "from booking b\n" +
            "left join ticket t on b.id = t.booking_id\n" +
            "left join `schedule` sc on t.schedule_id = sc.id\n" +
            "left join  movie m on sc.movie_id = m.id\n" +
            "group by m.name\n" +
            "limit 8\n" +
            ";", nativeQuery = true)
    List<Movie> getAllMovieHot();
}
