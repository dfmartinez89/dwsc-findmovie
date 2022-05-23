package dwsc.proyecto.findmovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.findmovie.dao.MovieRepository;
import dwsc.proyecto.findmovie.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepo;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public List<Movie> findMovieByTitle(String title) {
		return movieRepo.findByTitle(title);
	}

	@Override
	public List<Movie> findMovieByYear(Integer year) {
		return movieRepo.findByYear(year);
	}

	@Override
	public List<Movie> findMovieByScore(double score) {
		return movieRepo.findByScoreGreaterThanEqual(score);
	}

	@Override
	public Optional<Movie> findMovieById(String id) {
		return movieRepo.findById(id);
	}

}
