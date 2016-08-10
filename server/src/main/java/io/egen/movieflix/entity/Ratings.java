package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Ratings.findMovieRatings",query = "Select r from Ratings r where r.movieId = :pMovieId"),
})
public class Ratings {
	
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	private int rating;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne
	@JoinColumn(name = "userId")
	private Users users;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movies movies;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Movies getMovies() {
		return movies;
	}
	public void setMovies(Movies movies) {
		this.movies = movies;
	}
	
	@Override
	public String toString() {
		return "Ratings [id=" + id + ", rating=" + rating + ", users=" + users + ", movies=" + movies + "]";
	}

}