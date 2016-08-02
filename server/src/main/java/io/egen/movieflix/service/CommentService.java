package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Comments;

public interface CommentService {

	public Comments add(String movieId, Comments comments);

	public List<Comments> findByMovie(String movieId);
	
	public Comments findById(String id);

	public Comments update(String movieId, Comments comment);

	public void delete(String id);

}
