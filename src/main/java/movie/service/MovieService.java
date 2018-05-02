package movie.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Movie service handling all movie related queries. Relies on a third party service.
 */
@Service
public class MovieService {

    @Value("${apikey}")
    private String apikey;

    private static final String IMDB_MOVIE_REQUEST_URL = "https://www.omdbapi.com/?apikey=%s&r=xml&t=%s";

    /**
     * Calls a third party service which searches a movie DB for a given title
     *
     * @param movieTitle
     * @return String XML response
     */
    public String findMovie(String movieTitle) {
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try{
            URL url = new URL(String.format(IMDB_MOVIE_REQUEST_URL, apikey, movieTitle));
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
