package dwsc.proyecto.findmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FindMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindMovieApplication.class, args);
	}

}
