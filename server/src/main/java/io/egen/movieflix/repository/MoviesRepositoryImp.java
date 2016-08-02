package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Movies;

@Repository
public class MoviesRepositoryImp implements MoviesRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movies> findAll() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findAll", Movies.class);
		return query.getResultList();
	}

	@Override
	public Movies findOne(String id) {
		return em.find(Movies.class, id);
	}

	@Override
	public Movies create(Movies movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movies update(Movies movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movies movie) {
		em.remove(movie);
	}

	@Override
	public List<Movies> findByGenre(String genre) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByGenre", Movies.class);
		query.setParameter("pGenreType",genre);
		return query.getResultList();
	}

	@Override
	public List<Movies> findByYear(int year) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByYear", Movies.class);
		query.setParameter("pYear",year);
		return query.getResultList();
	}

	@Override
	public List<Movies> findByDirector(String director) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByDirector", Movies.class);
		query.setParameter("pDirectorName",director);
		return query.getResultList();
	}

	@Override
	public List<Movies> findByActor(String actor) {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.findByActor", Movies.class);
		query.setParameter("pActorName",actor);
		return query.getResultList();
	}

	@Override
	public List<Movies> sortByYear() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortByYear", Movies.class);
		return query.getResultList();
	}

	@Override
	public List<Movies> sortByRating() {
		TypedQuery<Movies> query = em.createNamedQuery("Movies.sortByRating", Movies.class);
		return query.getResultList();
	}

	
	

}
