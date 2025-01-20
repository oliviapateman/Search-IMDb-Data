package com.example.IMDbExercise;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
public class ImportBasics {

    @Autowired
    MoviesRepository moviesRepository;

    private static final Logger logger = LoggerFactory.getLogger(ImportBasics.class);

    public Path getBasicsFileFromDir() throws IOException {
        File tempFile = Files.createTempFile("title.basics.tsv", ".gz").toFile();
        Path path;
        logger.info(String.valueOf(tempFile.exists()));
        logger.info(String.valueOf(tempFile.canRead()));
        logger.info(String.valueOf(tempFile.isDirectory()));
        logger.info(new File(".").getAbsolutePath());
        path = Paths.get("title.basics.tsv.gz");
        return path.toAbsolutePath();
    }

    public CSVParser importFile(Path path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(String.valueOf(path));
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        CSVFormat format = CSVFormat.TDF.builder()
                .setHeader(BasicsDataHeaders.class)
                .setSkipHeaderRecord(true)
                .setNullString("N/A")
                .setQuote(null)
                .setIgnoreEmptyLines(true)
                .get();
        return format.parse(bufferedReader);
    }

    public void basicsParsing(CSVParser records) {
        int count = 0;
        int limit = 1000;
        List<Movies> imdbData = new ArrayList<>();

        for (CSVRecord record : records) {
            int tconst = Integer.parseInt(record.get("tconst").substring(2));
            String titleType = record.get("titleType");
            String primaryTitle = record.get("primaryTitle");
            String originalTitle = record.get("originalTitle");
            Movies movie = new Movies(tconst, titleType, primaryTitle, originalTitle);
            imdbData.add(movie);
            count++;
            if (count % limit == 0) {
                moviesRepository.saveAll(imdbData);
                imdbData.clear();
                System.out.println(count + " movies added");
            }
        }
        if (!imdbData.isEmpty()) {
            moviesRepository.saveAll(imdbData);
            System.out.println(count + " remaining movies added");
        }
    }
}
