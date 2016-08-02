package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Stars;

@Repository
public class StarsRepositoryImp implements StarsRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Stars create(Stars star) {
		em.persist(star);
		return star;
	}

	@Override
	public Stars update(Stars star) {
		em.merge(star);
		return star;
	}

	@Override
	public void delete(Stars star) {
		em.remove(star);
		
	}

	@Override
	public Stars findFullCast(String movieId) {
		TypedQuery<Stars> query = em.createNamedQuery("Stars.findByMovie", Stars.class);
		query.setParameter("pMovieId",movieId);	
		List<Stars> stars =  query.getResultList();
		if(stars != null && stars.size() == 1) {
			return stars.get(0);
		}
		return null;
	}

	@Override
	public Stars findById(String id) {
		TypedQuery<Stars> query = em.createNamedQuery("Stars.findById", Stars.class);
		query.setParameter("pStarId",id);	
		List<Stars> stars =  query.getResultList();
		if(stars != null && stars.size() == 1) {
			return stars.get(0);
		}
		return null;
	}

}
