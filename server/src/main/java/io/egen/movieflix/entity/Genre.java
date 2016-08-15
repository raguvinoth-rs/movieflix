package io.egen.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
/*@NamedQueries({ 
	@NamedQuery(name = "Genre.findByMovie", query = "SELECT g FROM Genre g WHERE g.movieId=:pMovieId"),
})*/
public class Genre {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	private String genreType;
	
	public String getGenreType() {
		return genreType;
	}
	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	
	/*@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "movieId")
	private Movies movie;*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
/*	public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}*/
	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreType=" + genreType + "]";
	}
	
	
}
