package com.example.IMDbExercise;

import jakarta.persistence.ElementCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class ImportIMDBData {

    @ElementCollection
    List<String> lines = new ArrayList<>();

    public List<String> getImportFile(int limit) throws IOException, InterruptedException {
        
        //TODO: Don't hardcode this
        File filePath = new File("C:\\Users\\olivia.pateman\\Documents\\Academy37\\DevAcademy\\title.basics.tsv.gz");

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
             InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null && count < limit){
                    lines.add(line);
                    count++;
            }
        } catch (IOException e){
            e.printStackTrace(System.err);
        }
        return lines;
    }

}
