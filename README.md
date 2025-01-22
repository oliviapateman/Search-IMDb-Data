# IMDb Exercise

## About:
The project works by taking in a 'titles.basics.tsv.gz' file and parsing the information that is specified
by the data's headers. The information is then stored in an in-memory database. A welcome page, and a search page 
are accessible via a web browser. The search function on the webpage is conducted through a query that looks
through the database and matches the search keyword 
to the primary titles. Results are then displayed as a table below the search bar. 
Users can scroll through the table to find their desired result.

This project was built in IntelliJ IDEA.

### Prerequisites:
- Must have title.basics.tsv.gz downloaded (from [here](https://datasets.imdbws.com/)) and stored in the project folder.  
_(The data is for personal and non-commercial use.)_
- Use an IDE to run the program.

### To run the program:
- Ensure file is in project folder.
- Executing via commandline: ./mvnw spring-boot:run  
OR
- Through an IDE: Execute Maven Goal -> mvn spring-boot:run
- Open webpage urls: http://localhost:8080/ and http://localhost:8080/searchimdb
- Search for a title in the search bar.

### Dependencies:
- Apache Commons
- Spring Boot JPA
- Spring Boot Starter Web
- Spring Boot DevTools
- Spring Boot ThymeLeaf
- H2 Database
