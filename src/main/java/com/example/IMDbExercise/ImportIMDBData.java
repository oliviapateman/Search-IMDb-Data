package com.example.IMDbExercise;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
public class ImportIMDBData {

    @Autowired MoviesRepository moviesRepository;

    public void importFile() throws IOException {

        //TODO: Don't hardcode this
        File filePath = new File("C:\\Users\\olivia.pateman\\Documents\\Academy37\\DevAcademy\\title.basics.tsv.gz");

        FileInputStream fileInputStream = new FileInputStream(filePath);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        CSVFormat format = CSVFormat.TDF.builder()
                .setHeader(DataHeaders.class)
                .setSkipHeaderRecord(true)
                .setQuote(null)
                .get();
        CSVParser records = format.parse(bufferedReader);

        int count = 0;
        int limit = 1000;
        List<Movies> imdbData = new ArrayList<>();

        for (CSVRecord record : records){
            int tconst = Integer.parseInt(record.get("tconst").substring(2));
            String titleType = record.get("titleType");
            String primaryTitle = record.get("primaryTitle");
            boolean isAdult = Boolean.parseBoolean(record.get("isAdult"));
            Movies movie = new Movies(tconst, titleType, primaryTitle, isAdult);
            imdbData.add(movie);
            count++;
            if (count % limit == 0){

                moviesRepository.saveAll(imdbData);
                imdbData.clear();
                System.out.println(count + " movies added");
            }
        }
        if (!imdbData.isEmpty()){
            moviesRepository.saveAll(imdbData);
            System.out.println(count + " remaining movies added");
        }
    }

}
