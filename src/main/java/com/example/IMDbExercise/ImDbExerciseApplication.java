package com.example.IMDbExercise;

import org.apache.commons.csv.CSVParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;

@SpringBootApplication
public class ImDbExerciseApplication {

    public static void main(String[] args) {
		SpringApplication.run(ImDbExerciseApplication.class,args);
	}

	@Bean
	public CommandLineRunner showData(ImportBasics basics){
		return (args) -> {
			Path path = basics.getBasicsFileFromDir();
			CSVParser parser = basics.importFile(path);
			basics.basicsParsing(parser);
		};
	}

}
