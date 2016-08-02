package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Ratings;

public interface RatingRepository {
	
	public Ratings add(Ratings rating);
	
public Ratings update(Ratings rating);
	
	public List<Ratings> findByMovie(String movieId);

}
