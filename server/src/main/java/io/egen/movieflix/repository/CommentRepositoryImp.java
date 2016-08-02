package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Comments;

@Repository
public class CommentRepositoryImp implements CommentRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Comments add(Comments comment) {
		em.persist(comment);
		return comment;
	}
	
	@Override
	public Comments update(Comments comment){
		em.merge(comment);
		return comment;
	}
	
	@Override
	public void delete(Comments comment){
		em.remove(comment);
	}

	@Override
	public List<Comments> findByMovie(String movieId) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findMovieComments", Comments.class);
		query.setParameter("pMovieId",movieId);		
		List<Comments> comments =  query.getResultList();
		return comments;
	}

	@Override
	public Comments findById(String id) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findCommentById", Comments.class);
		query.setParameter("pCommentId",id);		
		List<Comments> comment =  query.getResultList();
		if(comment != null && comment.size() == 1) {
			return comment.get(0);
		}
		return null;
	}

}
