import ExtractHTMLFromURLs.fetchHTMLAndScreenShotsFrompkaymetal;
import ExtractHTMLFromURLs.fetchHTMLAndScreenshotsFromDemophorius;
import ExtractHTMLFromURLs.fetchHTMLAndScreenshotsFromSuneratech;
import ExtractHTMLFromURLs.fetchHTMLAndScreenshotsFromUschamber;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        fetchHTMLAndScreenshotsFromSuneratech suneratech = new fetchHTMLAndScreenshotsFromSuneratech();
        suneratech.fetchDetailsOfSuneratech();
        fetchHTMLAndScreenshotsFromUschamber uschamber = new fetchHTMLAndScreenshotsFromUschamber();
        uschamber.fetchDetailsOfUscHamber();
        fetchHTMLAndScreenshotsFromDemophorius demophorius = new fetchHTMLAndScreenshotsFromDemophorius();
        demophorius.fetchDetailsOfDemophorius();
        fetchHTMLAndScreenShotsFrompkaymetal pkaymetal = new fetchHTMLAndScreenShotsFrompkaymetal();
        pkaymetal.fetchDetailsOfPkaymetal();
    }

}
