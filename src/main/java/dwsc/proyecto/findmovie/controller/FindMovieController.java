package dwsc.proyecto.findmovie.controller;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dwsc.proyecto.findmovie.domain.Movie;
import dwsc.proyecto.findmovie.exceptions.CustomResponse;
import dwsc.proyecto.findmovie.exceptions.MovieNotFoundException;
import dwsc.proyecto.findmovie.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "movies", description = "find movie")
@RequestMapping(value = "/movies")
public class FindMovieController {
	@Autowired
	MovieService movieService;

	@Operation(summary = "Get all movies", description = "Operation to all movies in DB")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "movies listed succesfully"),
			@ApiResponse(responseCode = "404", description = "movie not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> getMovies() throws MovieNotFoundException {
		List<Movie> movies = movieService.getAllMovies();
		if (movies.isEmpty()) {
			throw new MovieNotFoundException(HttpStatus.NOT_FOUND, "There are no movies in our database");
		}
		return ResponseEntity.ok(movies);
	}

	@Operation(summary = "Get all movies by title", description = "Operation to search all movies that have a given title")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "movies listed succesfully"),
			@ApiResponse(responseCode = "404", description = "movie not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.GET, path = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Movie>> getMoviesByTitle(
			@Parameter(description = "Movie title") @RequestParam String title) throws MovieNotFoundException {
		Iterable<Movie> movies = movieService.findMovieByTitle(title);
		if (IterableUtils.isEmpty(movies)) {
			throw new MovieNotFoundException(HttpStatus.NOT_FOUND,
					"There are no movies with title: " + title + " in our database");
		}
		return ResponseEntity.ok(movies);
	}

	@Operation(summary = "Get all movies by year", description = "Operation to search all movies that have a given year")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "movies listed succesfully"),
			@ApiResponse(responseCode = "404", description = "movie not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.GET, path = "/year", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Movie>> getMoviesByYear(
			@Parameter(description = "Movie year") @RequestParam Integer year) throws MovieNotFoundException {
		Iterable<Movie> movies = movieService.findMovieByYear(year);
		if (IterableUtils.isEmpty(movies)) {
			throw new MovieNotFoundException(HttpStatus.NOT_FOUND,
					"There are no movies with year: " + year + " in our database");
		}
		return ResponseEntity.ok(movies);
	}

	@Operation(summary = "Get all movies by score", description = "Operation to search all movies that have a given score")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "movies listed succesfully"),
			@ApiResponse(responseCode = "404", description = "movie not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.GET, path = "/score", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Movie>> getMoviesByScore(
			@Parameter(description = "Movie score") @RequestParam Double score) throws MovieNotFoundException {
		Iterable<Movie> movies = movieService.findMovieByScore(score);
		if (IterableUtils.isEmpty(movies)) {
			throw new MovieNotFoundException(HttpStatus.NOT_FOUND,
					"There are no movies with score: " + score + " in our database");
		}
		return ResponseEntity.ok(movies);
	}

}
