package ExtractHTMLFromURLs;

import Utils.ExtractJSON;
import Utils.fetchHTMLFromEveryExtractURLsByVisitingURLs;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class fetchHTMLAndScreenshotsFromDemophorius {

    public void fetchDetailsOfDemophorius() throws IOException, ParseException, InterruptedException {
        String domainName = "demophorius";
        String OutputJSON = domainName+"OutputJSON";
        String ScreenShotFileName = domainName+"ScreenShots";
        ExtractJSON extractJSON = new ExtractJSON();
        JSONArray jsonArray = extractJSON.ExtractJSON();
        String mainUrl = (String) jsonArray.get(2);
        fetchHTMLFromEveryExtractURLsByVisitingURLs fetchDetails = new fetchHTMLFromEveryExtractURLsByVisitingURLs();
        fetchDetails.extractHTML(mainUrl,domainName,OutputJSON,ScreenShotFileName,OutputJSON);
    }
}
