package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Users;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Users create(Users user) {
		em.persist(user);
		return user;
	}

	@Override
	public List<Users> findAll() {
		TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Users findById(String id) {
		return em.find(Users.class, id);
	}

	@Override
	public Users update(Users user) {
		return em.merge(user);
	}

	@Override
	public void delete(Users user) {
		em.remove(user);
	}

	@Override
	public Users login(String username, String password) {
		TypedQuery<Users> query = em.createNamedQuery("User.findUserByUsername", Users.class);
		query.setParameter("pUsername",username);
		List<Users> user =  query.getResultList();
		if(user != null && user.size() == 1) {
			if(user.get(0).getPassword() == password){
				//validating
			}
		}
		return null;
	}

}
