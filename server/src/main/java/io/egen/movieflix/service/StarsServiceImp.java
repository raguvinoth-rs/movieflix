package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movies;
import io.egen.movieflix.entity.Stars;
import io.egen.movieflix.exception.IDNotFoundException;
import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.repository.MoviesRepository;
import io.egen.movieflix.repository.StarsRepository;

@Service
public class StarsServiceImp implements StarsService {
	
	@Autowired
	StarsRepository repository;
	@Autowired
	MoviesRepository mRepo;

	@Override
	@Transactional
	public Stars create(Stars star) {
		return repository.create(star);
	}

	@Override
	@Transactional
	public Stars update(String movieId, Stars star) {
		Movies movie = mRepo.findOne(movieId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		return repository.update(star);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Stars existing = repository.findById(id);
		if (existing == null) {
			throw new IDNotFoundException("ID not found");
		}
		repository.delete(existing);		
	}

	@Override
	public Stars findFullCast(String movieId) {
		return  repository.findFullCast(movieId);
	}

}
