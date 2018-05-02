# MovieSearch

The project utilizes Spring-boot since it makes development much 
faster. I have also included org.json json library to easily transform 
the XML responses to JSON.

## Dependencies

You have to have maven installed. If you don't have it installed please visit <https://maven.apache.org/download.cgi>

If for some reason the code does not compile or is not working it could be that
the **apikey** for the third party service has expired. If that is the case
you can visit <https://www.omdbapi.com/>, register for your own api key and 
when you have it just replace the existing property value for _apikey_ with your own key inside the **application.properties** file.  

## Run

`./mvnw spring-boot:run`

#### Alternative way to run

Execute: 

`mvn clean package`

Followed by:

`java -jar target/movie-search-0.1.0.jar`

When you choose your way to run the project 
then open the URL <http://localhost:8080/movie?title=lost> 
where _lost_ is the search term for the movie title.