package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Ratings;
import io.egen.movieflix.service.RatingService;

@RestController
@RequestMapping(path = "ratings")
public class RatingsController {
	
	@Autowired
	RatingService service;
	
	@RequestMapping(method = RequestMethod.POST,path="/add/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ratings add(@PathVariable("movieId") String movieId,@RequestBody Ratings rating) {
		 return service.add(movieId,rating);		 
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="/update/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ratings update(@PathVariable("movieId") String movieId,@RequestBody Ratings rating) {
		 return service.update(movieId,rating);		 
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/view/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ratings> findByMovie(@PathVariable("movieId")String movieId) {
		return service.findByMovie(movieId);
	}
	

}
