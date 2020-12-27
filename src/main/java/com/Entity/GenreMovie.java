package com.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "genremovie")
public class GenreMovie {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "genreid", unique = true, nullable = false)
	private Integer genreId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "genreMovie")
	@JsonIgnore
	private List<MovieGenreDetail> movieGenreDetail;

	public GenreMovie() {
		super();
	}

	public GenreMovie(Integer genreId, String name, List<MovieGenreDetail> movieGenreDetail) {
		super();
		this.genreId = genreId;
		this.name = name;
		this.movieGenreDetail = movieGenreDetail;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieGenreDetail> getMovieGenreDetail() {
		return movieGenreDetail;
	}

	public void setMovieGenreDetail(List<MovieGenreDetail> movieGenreDetail) {
		this.movieGenreDetail = movieGenreDetail;
	}

}
