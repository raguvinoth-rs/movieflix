package io.egen.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Stars;
import io.egen.movieflix.service.StarsService;

@RestController
@RequestMapping(path = "star")
public class StarsController {
	
	@Autowired
	StarsService service;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Stars create(@RequestBody Stars star){
		return service.create(star);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Stars update(@PathVariable("movieId") String movieId,@RequestBody Stars star) {
		 return service.update(movieId,star);		 
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
	
}
