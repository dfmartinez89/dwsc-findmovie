package dwsc.proyecto.findmovie.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dwsc.proyecto.findmovie.domain.Movie;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieRepository extends MongoRepository<Movie, String> {
	List<Movie> findByTitle(@Param("title") String title);

	List<Movie> findByYear(@Param("title") Integer year);

	List<Movie> findByScoreGreaterThanEqual(@Param("scoreAverage") double score);
}
