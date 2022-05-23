package dwsc.proyecto.findmovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dwsc.proyecto.findmovie.domain.Movie;

@Service
public interface MovieService {
	public List<Movie> getAllMovies();

	public Optional<Movie> findMovieById(String id);

	public List<Movie> findMovieByTitle(String title);

	public List<Movie> findMovieByYear(Integer year);

	public List<Movie> findMovieByScore(double score);
}
