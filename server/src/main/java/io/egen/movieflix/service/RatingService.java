package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Ratings;

public interface RatingService {
	
	public Ratings add(String movieId, Ratings rating);
	
	public Ratings update(String movieId, Ratings rating);
	
	public List<Ratings> findByMovie(String movieId);

}
