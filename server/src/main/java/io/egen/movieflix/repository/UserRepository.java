package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Users;

public interface UserRepository {
	
	public Users create(Users user);
	public List<Users> findAll();
	public Users findById(String id);
	public Users update(Users user);
	public void delete(Users user);
	public Users login(String username, String password);

}
