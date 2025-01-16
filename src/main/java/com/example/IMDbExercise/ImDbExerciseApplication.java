package com.example.IMDbExercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class ImDbExerciseApplication {

    public static void main(String[] args) {
		SpringApplication.run(ImDbExerciseApplication.class,args);
	}

	@Bean
	public CommandLineRunner showData(ImportIMDBData importIMDBData){
		return (args) -> {
			importIMDBData.importFile();
		};
	}

}
