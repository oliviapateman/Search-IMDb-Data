package com.example.IMDbExercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImDbExerciseApplication {

	private static final Logger log = LoggerFactory.getLogger(ImDbExerciseApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(ImDbExerciseApplication.class, args);
	}

	@Bean
	public CommandLineRunner showData(MoviesRepository repository){
		return (args) -> {
			log.info("Movies found by searching for title: ");
			log.info("-------------------------------");
			repository.findByPrimaryTitle("the").forEach(movies -> {
				log.info(movies.toString());
			});
			log.info("");
		};
	}

}
