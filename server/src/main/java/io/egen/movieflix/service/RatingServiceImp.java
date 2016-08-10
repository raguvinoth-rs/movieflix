package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movies;
import io.egen.movieflix.entity.Ratings;
import io.egen.movieflix.entity.Users;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.exception.UserNotFoundException;
import io.egen.movieflix.repository.MoviesRepository;
import io.egen.movieflix.repository.RatingRepository;
import io.egen.movieflix.repository.UserRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository repository;

	@Autowired
	MoviesRepository mRepo;

	@Autowired
	UserRepository uRepo;

	@Override
	@Transactional
	public Ratings add(String movieId, Ratings rating) {
		Movies movie = mRepo.findOne(rating.getMovies().getMovieId());
		Users user = uRepo.findById(rating.getUsers().getUserId());
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		rating.setMovies(movie);
		rating.setUsers(user);
		return repository.add(rating);
	}

	@Override
	@Transactional
	public Ratings update(String movieId, Ratings rating) {
		Movies movie = mRepo.findOne(rating.getMovies().getMovieId());
		Users user = uRepo.findById(rating.getUsers().getUserId());
		if (movie == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		rating.setMovies(movie);
		rating.setUsers(user);
		return repository.update(rating);
	}

	@Override
	public List<Ratings> findByMovie(String movieId) {
		return repository.findByMovie(movieId);
	}

}
