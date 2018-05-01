package movie.controller;

import movie.service.MovieService;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private static final int PRETTY_PRINT_INDENT_FACTOR = 4;

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movie")
    public String greeting(@RequestParam(value="title", defaultValue="lost") String title) {
        try {
            String response = movieService.getMovieXML(title);
            JSONObject xmlJSONObj = XML.toJSONObject(response);
            return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        } catch (org.json.JSONException je) {
            System.out.println(je.toString());
        }
        return null;
    }
}
