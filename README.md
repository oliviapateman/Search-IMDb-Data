# IMDb Exercise

## About:
This project imports, unzips, and reads the Title Basics IMDb data file. 
The project uses Spring Boot and H2Database.  
It is designed to run webpages with urls: http://localhost:8080/ and http://localhost:8080/searchimdb
to enable users to search through the primary titles of the data. The results table displays 
each result's ID, primary title and original title.

The project works by taking in the file, parsing the information that is specified 
by the headers. The information is then stored as a database in the MoviesRepository.
The search function on the webpage is conducted through a query that looks through the 
database and matches the search keyword to the primary titles. Results are then displayed as a
table below the search bar. Users can scroll through the table to find their desired result.

To run the project through Idea: Execute Maven Goal -> mvn spring-boot:run

### Prerequisites:
- Must have title.basics.tsv.gz downloaded (from [here](https://datasets.imdbws.com/)) and stored in the project folder.  
_(The data is for personal and non-commercial use.)_

### Dependencies:
- Apache Commons
- Spring Boot JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- Spring Boot ThymeLeaf
- H2 Database
