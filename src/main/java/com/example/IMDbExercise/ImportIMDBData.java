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
                .get();
        CSVParser records = format.parse(bufferedReader);

        int count = 0;
        int limit = 500;
        List<Movies> imbdData = new ArrayList<>();

        for (CSVRecord record : records){
            if (count >= limit){
                break;
            }
            String titleType = record.get("titleType");
            String primaryTitle = record.get("primaryTitle");
            boolean isAdult = Boolean.parseBoolean(record.get("isAdult"));
            Movies movie = new Movies(titleType, primaryTitle, isAdult);
            imbdData.add(movie);
            count++;
        }
        moviesRepository.saveAll(imbdData);
        System.out.println(imbdData);
    }

}
