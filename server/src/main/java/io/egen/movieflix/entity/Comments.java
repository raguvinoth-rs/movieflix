package io.egen.movieflix.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Comments.findMovieComments",query = "Select c from Comment c where c.movieId = :pMovieId"),
	@NamedQuery(name="Comments.findCommentById",query = "Select c from Comment c where c.id = :pCommentId"),
})
public class Comments {
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	private String comments;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private Users users;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId")
	private Movies movies;
		
	public Movies getMovies() {
		return movies;
	}
	public void setMovies(Movies movies) {
		this.movies = movies;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", comments=" + comments + ", users=" + users + ", movies=" + movies
				+ "]";
	}
	
	
}
