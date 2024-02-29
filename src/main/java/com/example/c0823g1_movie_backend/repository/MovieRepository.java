package com.example.c0823g1_movie_backend.repository;

import com.example.c0823g1_movie_backend.dto.HistoryBookingDTO;
import com.example.c0823g1_movie_backend.dto.MovieDTO;
import com.example.c0823g1_movie_backend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.Optional;

import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "select count(b.account_id) as accountId,m.name as name, " +
            "max(m.description )as description," +
            "max(m.poster) as poster\n" +
            "from booking b\n" +
            "left join ticket t on b.id = t.booking_id\n" +
            "left join `schedule` sc on t.schedule_id = sc.id\n" +
            "left join  movie m on sc.movie_id = m.id\n" +
            "group by m.name\n" +
            "order by count(b.account_id) desc\n" +
            "limit 8", nativeQuery = true)
    List<MovieDTO> getAllMovieHot();

    @Query(value = "select m.name as name,m.description as description, m.poster as poster\n" +
            "from movie m\n" +
            "where m.name like :title", nativeQuery = true)
    Page<MovieDTO> searchMovie(@Param("title") String value, Pageable pageable);


    @Query(value = "select count(m.id) as movieId,max(m.name) as name,\n" +
            "max(m.description) as description\n" +
            ", max(m.poster) as poster\n" +
            "from movie m \n" +
            "join schedule sc on m.id = sc.movie_id\n" +
            "where sc.`date` = current_date\n" +
            "group by m.name\n", nativeQuery = true)
    List<MovieDTO> getAllMovieCurrent();


    @Query(value = "select id, actor, country, description, director, duration, is_deleted, name,poster, publisher, start_date, ticket_price,trailer from movie " +
            "where (name like :name or publisher like :publisher) and start_date BETWEEN :startDate AND :endDate and is_deleted = 0 ", nativeQuery = true)
    Page<Movie> searchMovieByNameAndPublisher(@Param("name") String name, @Param("publisher") String publisher
            , @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET is_deleted = 1 where id  =:id", nativeQuery = true)
    void deleteMovieById(@Param("id") long id);

    @Modifying
    @Query(value = "insert into movie(director,actor)" +
            "values (:#{#movie.director},:#{#movie.actor})", nativeQuery = true)
    void createMovie(@Param("movie") Movie movie);

    @Query(value = "SELECT m FROM Movie m WHERE m.id = :id")
    Optional<Movie> findByIdMovie(Long id);




    @Query(value = "select id, actor, country, description, director, duration, is_deleted, name,poster, publisher, start_date, ticket_price,trailer from movie " +
            "where id  =:id and is_deleted =0", nativeQuery = true)
    Movie findMovieById(@Param("id") Long id);
}
