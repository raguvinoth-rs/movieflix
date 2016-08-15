package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Movies;
import io.egen.movieflix.service.MoviesService;


@RestController      // Combination of @ResponseBody and @Controller
@RequestMapping(path="movies")
public class MoviesController {

	@Autowired
	MoviesService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/findById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies findOne(@PathVariable("id") String movId){
		return service.findOne(movId);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByGenre/{genre}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByGenre(@PathVariable("genre") String genre) {
		return service.findByGenre(genre);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByYear/{year}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByYear(@PathVariable("year") int year) {
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByDirector/{director}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByDirector(@PathVariable("director") String director) {
		return service.findByDirector(director);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByActor/{actor}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> findByActor(@PathVariable("actor") String actor) {
		return service.findByActor(actor);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> sortByYear() {
		return service.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByRating",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movies> sortByRating() {
		return service.sortByRating();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies create(@RequestBody Movies movie){
		return service.create(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies update(@PathVariable("id") String movId, @RequestBody Movies movie){
		return service.update(movId, movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String movId){
		service.delete(movId);
	}
	
	
}
