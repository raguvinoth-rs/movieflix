package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.entity.Comments;

public interface CommentRepository {
	
	public Comments add(Comments comments);
	
	public List<Comments> findByMovie(String movieId);
	
	public Comments findById(String id);
	
	public Comments update(Comments comment);
	
	public void delete(Comments comment);
	

}
