package com.example.c0823g1_movie_backend.controller;

import com.example.c0823g1_movie_backend.dto.*;
import com.example.c0823g1_movie_backend.model.*;
import com.example.c0823g1_movie_backend.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
public class MovieRestController {
    private final IMovieService movieService;
    private final IGenreService genreService;
    private final IVersionService versionService;
    private final IScheduleTimeService scheduleTimeService;
    private final IHallService hallService;

    @Autowired
    public MovieRestController(IMovieService movieService, IGenreService genreService, IVersionService versionService, IScheduleTimeService scheduleTimeService, IHallService hallService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.versionService = versionService;
        this.scheduleTimeService = scheduleTimeService;
        this.hallService = hallService;
    }
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
    public ResponseEntity<Page<MovieStatisticDTO>> movieStatistics(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                   @RequestParam(name = "name", defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<MovieStatisticDTO> movieList = movieService.getMovieStatistic(name, pageable);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/statistics/top20")
    public ResponseEntity<Page<MovieStatisticDTO>> movieStatisticsTop20(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                        @RequestParam(name = "name", defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<MovieStatisticDTO> movieList = movieService.getMovieStatistic(name, pageable);
        if (movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    /*    Create by: BaoLVN
     *     Date created : 29/02/2024
     *     Function: Get a list of movies with many views
     *     @return HttpStatus.NO_CONTENT not available if no listing is found/ HttpStatus.OK and list movie found
     * */
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
        List<IMovieDTO> list = movieService.getAllMovieCurrent();
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
        Pageable pageable = PageRequest.of(page, 4);
        Page<IMovieDTO> searchMovies = movieService.searchMovie(value.trim(), pageable);
        if (searchMovies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchMovies, HttpStatus.OK);
    }

    /**
     * Created by: LamNT
     * Date created: 29/02/2024
     * Function: save new movie and schedule to database
     *
     * @return HTTPStatus.OK movie update succeed, HttpStatus.BAD_REQUEST if movie or schedule not valid
     */
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody @Valid MovieDTO newMovie, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Long> versions = newMovie.getVersion();
        List<Long> genres = newMovie.getGenre();
        Long newId = movieService.createMovie(newMovie, versions, genres);
        return new ResponseEntity<>(newId, HttpStatus.OK);
    }

    /**
     * Created by: LamNT
     * Date created: 03/03/2024
     * Function: update movie and schedule in database
     *
     * @return HTTPStatus.OK movie update succeed, HttpStatus.BAD_REQUEST if movie or schedule not valid
     */
    @PatchMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody @Valid MovieRequestBodyDTO movieRequestBodyDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MovieDTO movie = movieRequestBodyDTO.getMovieDTO();
        Set<ScheduleDTO> scheduleDTO = movieRequestBodyDTO.getScheduleDTO();
        List<Long> versions = movie.getVersion();
        List<Long> genres = movie.getGenre();
        boolean result = movieService.editMovie(movie, scheduleDTO, versions, genres);
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Created by: LamNT
     * Date created: 04/03/2024
     * Function: return all the attributes that get data from database
     *
     * @return HTTPStatus.OK
     */
    @GetMapping("/attributes")
    public ResponseEntity<MovieAttributeDTO> getAllAttributes() {
        List<Genre> genres = genreService.getAll();
        List<Version> versions = versionService.getAll();
        List<ScheduleTime> scheduleTimes = scheduleTimeService.getAll();
        List<Hall> halls = hallService.getAll();
        return new ResponseEntity<>(new MovieAttributeDTO(genres, versions, scheduleTimes, halls), HttpStatus.OK);
    }

    /**
     * Created by: LamNT
     * Date created: 10/03/2024
     * Function: return true if there is duplicated movie, false if not
     *
     * @return HTTPStatus.OK
     */
    @PostMapping("/check")
    ResponseEntity<Boolean> checkIfDuplicated(@RequestBody MovieDTO movieDTO) {
        List<Long> movie = movieService.checkIfDuplicated(movieDTO);
        boolean result = !movie.isEmpty();
        return new ResponseEntity<>(result, HttpStatus.OK);
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Page<IMovieListDTO>> findAllMovie(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "") String publisher,
                                                            @RequestParam(defaultValue = "") String name,
                                                            @RequestParam(defaultValue = "2001-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                            @RequestParam(defaultValue = "2100-01-01") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Pageable pageable = PageRequest.of(page, 6, Sort.by("start_date").descending()
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
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<MovieDTO> findMovieInfoById(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        MovieDTO movieDTO = new MovieDTO();
        BeanUtils.copyProperties(movie, movieDTO);
        List<Long> genres = genreService.getGenreByMovieId(id);
        List<Long> versions = versionService.getVersionByMovieId(id);
        List<String> genreArray = new ArrayList<>();
        for (Long genre : genres) {
            genreArray.add(String.valueOf(genre));
        }
        List<String> versionArray = new ArrayList<>();
        for (Long version : versions) {
            versionArray.add(String.valueOf(version));
        }
        movieDTO.setGenresString(genreArray);
        movieDTO.setVersionsString(versionArray);
        return new ResponseEntity<>(movieDTO, HttpStatus.OK);
    }

    @GetMapping("/current1")
    public ResponseEntity<List<IMovieDTO>> getAllMovieCurrentTo3Day() {
        List<IMovieDTO> list = movieService.getAllMovieCurrentTo3Day();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
