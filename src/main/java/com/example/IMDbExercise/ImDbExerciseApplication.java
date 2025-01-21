package com.example.IMDbExercise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImDbExerciseApplication {

    public static void main(String[] args) {
		SpringApplication.run(ImDbExerciseApplication.class,args);
	}

	@Bean
	public CommandLineRunner showData(ImportFiles importing){
		return (args) -> {
			importing.fileParsing(importing.importBasicsFile(importing.getBasicsFileFromDir()));
		};
	}

}
