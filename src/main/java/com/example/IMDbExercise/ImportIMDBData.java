package com.example.IMDbExercise;

import org.aspectj.apache.bcel.util.Repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class ImportIMDBData {

    Path filePath = Paths.get("title.basics.tsv.gz");
    List<String> lines = new ArrayList<>();

    public List<String> getImportFile(){
        try (FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
             InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }

}
