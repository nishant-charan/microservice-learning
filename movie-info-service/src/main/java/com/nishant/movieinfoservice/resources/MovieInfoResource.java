package com.nishant.movieinfoservice.resources;

import com.nishant.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {


    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("1234", "Avengers", "Marvels superheroes come together"));
        movieList.add(new Movie("2345", "Avengers : Age of Ultron", "Evolution of Ultron"));
        for (Movie movie : movieList) {
            if (movie.getMovieId().equals(movieId)) {
                return movie;
            }
        }
        return null;
    }

}
