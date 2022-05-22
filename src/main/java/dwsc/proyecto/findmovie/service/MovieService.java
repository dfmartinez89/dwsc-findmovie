package dwsc.proyecto.findmovie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dwsc.proyecto.findmovie.domain.Movie;

@Service
public interface MovieService {
	public List<Movie> getAllMovies();

	public Iterable<Movie> findMovieByTitle(String title);

	public Iterable<Movie> findMovieByYear(Integer year);

	public Iterable<Movie> findMovieByScore(double score);
}
