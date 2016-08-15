package io.egen.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m ORDER BY m.title ASC"),
		@NamedQuery(name = "Movies.findByYear", query = "SELECT m FROM Movies m WHERE m.year=:pYear"),
		@NamedQuery(name = "Movies.findById", query = "SELECT m FROM Movies m WHERE m.id=:pId"),
		/*@NamedQuery(name = "Movies.findByDirector", query = "SELECT m FROM Movies m WHERE m.director.id=:pDirectorId"),*/
		/*@NamedQuery(name = "Movies.findByActor", query = "SELECT m FROM Movies m WHERE m.star.actor=:pActorName"),*/
		/*@NamedQuery(name = "Movies.findByGenre", query = "Select m from Movie m order by m.genreType=:pGenreType"),*/
		@NamedQuery(name = "Movies.sortByYear", query = "Select m from Movies m order by m.year DESC"),
		/*@NamedQuery(name = "Movies.sortByRating", query = "Select m from Movies m order by m.ratings.rating DESC")*/ })
public class Movies {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String movieId;

	private String title;
	private String rated;
	private String runTime;
	private String plot;
	private String language;
	private String poster;

	private int year;

	/*@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Stars star;*/

	/*@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "directorId")
	private Director director;*/

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private List<Genre> genre;

	/*@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Ratings ratings;*/

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Comments> comments;

	/*public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
*/
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", title=" + title + ", rated=" + rated + ", runTime=" + runTime
				+ ", plot=" + plot + ", language=" + language + ", poster=" + poster + ", year=" + year + "]";
	}

	/*public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public Stars getStar() {
		return star;
	}

	public void setStar(Stars star) {
		this.star = star;
	}*/

	

	

}
