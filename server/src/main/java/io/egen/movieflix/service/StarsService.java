package io.egen.movieflix.service;

import io.egen.movieflix.entity.Stars;

public interface StarsService {

	public Stars create(Stars star);

	public Stars update(String movieId, Stars star);

	public void delete(String id);

	public Stars findFullCast(String movieId);

}
