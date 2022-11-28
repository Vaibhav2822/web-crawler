package Utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ExtractJSON  {

    public JSONArray ExtractJSON() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("C:\\Users\\vaibh\\webCrawler\\src\\main\\java\\Dataset\\seed_url.json"));
        return jsonArray;
    }
}
