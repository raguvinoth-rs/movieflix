package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Ratings;

@Repository
public class RatingRepositoryImp implements RatingRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Ratings add(Ratings rating) {
		em.persist(rating);
		 return rating;
	}

	@Override
	public Ratings update(Ratings rating) {
		em.merge(rating);
		return rating;
	}

	@Override
	public List<Ratings> findByMovie(String movieId) {
		TypedQuery<Ratings> query = em.createNamedQuery("Ratings.findMovieRatings", Ratings.class);
		query.setParameter("pMovieId",movieId);		
		List<Ratings> ratings =  query.getResultList();
		return ratings;
	}

}
