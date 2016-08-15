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
	@NamedQuery(name = "Directors.findByMovie", query = "SELECT d FROM Directors d WHERE d.movieId=:pMovieId"),
})*/
public class Director {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	private String directorName;
	
	/*@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private Movies movie;*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	/*public Movies getMovie() {
		return movie;
	}
	public void setMovie(Movies movie) {
		this.movie = movie;
	}*/
	@Override
	public String toString() {
		return "Director [id=" + id + ", directorName=" + directorName + "]";
	}
	
}
