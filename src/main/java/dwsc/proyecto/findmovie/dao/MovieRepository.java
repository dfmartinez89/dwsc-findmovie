package dwsc.proyecto.findmovie.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dwsc.proyecto.findmovie.domain.Movie;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieRepository extends MongoRepository<Movie, String> {
	Iterable<Movie> findByTitle(@Param("title") String title);

	Iterable<Movie> findByYear(@Param("title") Integer year);

	Iterable<Movie> findByscoreAverageGreaterThanEqual(@Param("scoreAverage") double scoreAverage);
}
