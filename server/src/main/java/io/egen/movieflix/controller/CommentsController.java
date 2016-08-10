package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Comments;
import io.egen.movieflix.service.CommentService;

@RestController
@RequestMapping(path = "comments")
public class CommentsController {
	
	@Autowired
	CommentService service;
	
	@RequestMapping(method = RequestMethod.POST,path="/add/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments add(@PathVariable("movieId") String movieId, @RequestBody Comments comment) {
		return service.add(movieId, comment);		 
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/findById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments findById(@PathVariable("id") String id){
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="/update/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments update(@PathVariable("movieId") String movieId,@RequestBody Comments comment) {
		 return service.update(movieId,comment);		 
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByMovie/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comments> findByMovie(@PathVariable("movieId")String movieId) {
		return service.findByMovie(movieId);	
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="/delete/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String id) {
		 service.delete(id);		 
	}

}
