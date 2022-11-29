package ExtractHTMLFromURLs;

import Utils.ExtractJSON;
import Utils.fetchHTMLFromEveryExtractURLsByVisitingURLs;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class fetchHTMLAndScreenshotsFromUschamber {

    public void fetchDetailsOfUscHamber() throws IOException, ParseException, InterruptedException {
        String domainName = "uschamber";
        String OutputJSON = domainName+"OutputJSON";
        String ScreenShotFileName = domainName+"ScreenShots";
        ExtractJSON extractJSON = new ExtractJSON();
        JSONArray jsonArray = extractJSON.ExtractJSON();
        String mainUrl = (String) jsonArray.get(1);
        fetchHTMLFromEveryExtractURLsByVisitingURLs fetchDetails = new fetchHTMLFromEveryExtractURLsByVisitingURLs();
        fetchDetails.extractHTML(mainUrl,domainName,OutputJSON,ScreenShotFileName,OutputJSON);
    }

}
