package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.*;
import com.example.c0823g1_movie_backend.model.Movie;
import com.example.c0823g1_movie_backend.model.Schedule;
import com.example.c0823g1_movie_backend.service.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
public class MovieRestController {
    @Autowired
    private IMovieService movieService;
    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Get a list of movies with many views
     *     @return HttpStatus.NO_CONTENT not available if no listing is found/ HttpStatus.OK and list movie found
     * */

    /**
     * Created by DuyDD
     * Date Created: 29/02/2024
     * Function: Get a list of movies that have the highest revenue
     *
     * @return HttpStatus.NO_CONTENT if there are no movie/ HttpStatus.OK if there are
     */
    @GetMapping("/statistics")
    private ResponseEntity<Page<MovieStatisticDTO>> movieStatistics(@PageableDefault(value = 10) Pageable pageable) {
        Page<MovieStatisticDTO> movieList = movieService.getMovieStatistic(pageable);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<IMovieDTO>> getAllMovieHot() {
        List<IMovieDTO> list = movieService.getAllMovieHot();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Get the list of movies showing today
     *     @return HttpStatus.NO_CONTENT not available if no listing is found/ HttpStatus.OK and list movie found
     * */
    @GetMapping("/current")
    public ResponseEntity<List<IMovieDTO>> getAllMovieCurrent() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        List<IMovieDTO> list = movieService.getAllMovieCurrent();
        System.out.println(list.size());
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Search movie name and pagination
     *     @return HttpStatus.NOT_FOUND movies not found/ HttpStatus.OK movies has been found
     * */
    @GetMapping("/search")
    public ResponseEntity<Page<IMovieDTO>> searchMovies(@RequestParam(name = "name", defaultValue = "") String value,
                                                        @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<IMovieDTO> searchMovies = movieService.searchMovie(value, pageable);
        if (searchMovies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println(searchMovies.getSize());
        return new ResponseEntity<>(searchMovies, HttpStatus.OK);
    }

    /**
     * Created by: LamNT
     * Date created: 29/02/2024
     * Function: save new movie to database
     *
     * @return HTTPStatus.OK movie update succeed
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MovieRequestBodyDTO movieRequestBodyDTO) {
        Movie newMovie = new Movie();
        List<Schedule> newSchedules = new ArrayList<>();
        BeanUtils.copyProperties(movieRequestBodyDTO.getMovieDTO(), newMovie);
        for (ScheduleDTO scheduleDTO : movieRequestBodyDTO.getScheduleDTO()) {
            Schedule newSchedule = new Schedule();
            BeanUtils.copyProperties(scheduleDTO, newSchedule);
            newSchedule.setMovie(newMovie);
            newSchedules.add(newSchedule);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by TuanNM
     * Date create: 29/02/2024
     * Method: See details of the movie
     *
     * @Param id movie
     * @Return movie information
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        String checkId = String.valueOf(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (checkId.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


    /**
     * Created by: ThuanTM
     * Date created: 29/2/2024
     * Function:
     * Display movie list combined with search and pagination
     *
     * @return HTTPStatus.OK if have list movie and HTTPStatus.NO_CONTENT if list movie null
     */

    @GetMapping("/list")
    public ResponseEntity<Page<IMovieListDTO>> findAllMovie(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "") String publisher,
                                                           @RequestParam(defaultValue = "") String name,
                                                           @RequestParam(defaultValue = "2001-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                           @RequestParam(defaultValue = "2100-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("start_date").descending()
                .and(Sort.by("name").ascending()));
        Page<IMovieListDTO> moviePage = movieService.searchMovieByNameAndPublisher(name, publisher, startDate, endDate, pageable);
        if (moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviePage, HttpStatus.OK);
    }

    /**
     * Created by: ThuanTM
     * Date created: 29/2/2024
     * Function: delete movie by id
     *
     * @return HTTPStatus.OK if movie delete and HTTPStatus.NOT_FOUND if  movie not found
     */
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
