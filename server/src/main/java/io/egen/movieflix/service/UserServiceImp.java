package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Users;
import io.egen.movieflix.exception.UserNotFoundException;
import io.egen.movieflix.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	@Transactional
	public Users create(Users user) {
		return repository.create(user);
	}

	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	public Users findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Users login(String username, String password) {
		/*Users existing = repository.findById(id);
		if (existing == null) {
			throw new UserNotFoundException("User not found");
		} else if (existing.getPassword() != password) {
			throw new UserDetailsIncorrectException("Username/password incorrect");
		}*/
		return repository.login(username, password);
	}

	@Override
	@Transactional
	public Users update(String id, Users user) {
		Users existing = repository.findById(id);
		if (existing == null) {
			throw new UserNotFoundException("User not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Users existing = repository.findById(id);
		if (existing == null) {
			throw new UserNotFoundException("User not found");
		}
		repository.delete(existing);
	}

}
