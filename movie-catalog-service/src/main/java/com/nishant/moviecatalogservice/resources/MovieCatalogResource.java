package com.nishant.moviecatalogservice.resources;

import com.nishant.moviecatalogservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public UserCatalog getCatalog(@PathVariable("userId") String userId) {

        /*UserRating userRating = restTemplate.getForObject("http://rating-data-service/rating/users/" + userId, UserRating.class);*/

        UserRating userRating = webClientBuilder.build()
                .get()
                .uri("http://rating-data-service/rating/users/" + userId).retrieve()
                .bodyToMono(UserRating.class)
                .block();

        List<CatalogItem> catalogItemList = userRating.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), movie.getDesc(),rating.getRating());
        })
        .collect(Collectors.toList());

        UserCatalog userCatalog = new UserCatalog();
        userCatalog.setUserCatalog(catalogItemList);
        return userCatalog;
    }
}
