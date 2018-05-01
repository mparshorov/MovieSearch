package movie.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class MovieService {

    private static final String IMDB_MOVIE_REQUEST_URL = "https://www.omdbapi.com/?apikey=b1fb3108&r=xml&t=%s";

    public String getMovieXML(String movieTitle) {
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try{
            URL url = new URL(String.format(IMDB_MOVIE_REQUEST_URL, movieTitle));
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return result.toString();
    }
}
