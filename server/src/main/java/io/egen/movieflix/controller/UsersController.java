package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Users;
import io.egen.movieflix.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UsersController {

	@Autowired
	UserService service;

	@RequestMapping(method = RequestMethod.POST, path = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users create(@RequestBody Users user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Users> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/find/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users find(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users update(@PathVariable("id") String userId, @RequestBody Users user){
		return service.update(userId, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String userId){
		service.delete(userId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/login/{username, password}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users login(@PathVariable("username") String username, @PathVariable("password") String password, @RequestBody Users user) {
		return service.login(username, password);
	}
}