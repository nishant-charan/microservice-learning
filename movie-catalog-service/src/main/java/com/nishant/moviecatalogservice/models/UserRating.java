package com.nishant.moviecatalogservice.models;

import java.util.List;

public class UserRating {
    public UserRating() {
    }

    List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
