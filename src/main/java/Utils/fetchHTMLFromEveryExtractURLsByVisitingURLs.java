package Utils;

import com.mongodb.DB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.mongodb.gridfs.GridFS;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class fetchHTMLFromEveryExtractURLsByVisitingURLs {

    public void extractHTML(String mainUrl,String domainName,String OutputJSON, String ScreenShotFileName,String colName) throws IOException, ParseException {
        ExtractURLsByVisiting crawler = new ExtractURLsByVisiting();
        String rootURL = mainUrl;
        List<String> visitedSites = crawler.crawl(rootURL, 100);
        MongoClient client = MongoClients.create("mongodb+srv://vaibhav_6162:123654789@cluster0.stfsjhy.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("Web_Crawler_DB");
        MongoCollection col = db.getCollection(colName);
        for (int i = 0; i < visitedSites.size(); i++) {
            String[] removeExtraWordsFromLink = new String[1];
            if (visitedSites.get(i).contains(">")) {
                removeExtraWordsFromLink = visitedSites.get(i).split(">");
            } else if (visitedSites.get(i).contains(",")) {
                removeExtraWordsFromLink = visitedSites.get(i).split(",");
            }
            else {
                removeExtraWordsFromLink[0] = visitedSites.get(i);
            }
            WebDriver driver = fetchDriver.getDriver();
            String url = removeExtraWordsFromLink[0];
            System.out.println(url);
            try {
                driver.get(url);
            }
            catch (Exception NoSuchWindowException){
                driver.close();
                continue;
            }
            if(url.contains(".jpg") || url.contains(".png") || url.contains(".jpeg")){
                TakesScreenshot scrShot =((TakesScreenshot)driver);
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(SrcFile, new File("C:\\Users\\vaibh\\webCrawler\\src\\main\\java\\ScreenShotsFolder\\"+ScreenShotFileName+"\\"+domainName+i+".png"));
            }
            String p = driver.getPageSource();
            TakesScreenshot newScreen = (TakesScreenshot) driver;
            String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
            String base64ScreenShot = scnShot;
            JSONObject urlContent = new JSONObject();
            urlContent.put("seed_url", rootURL);
            urlContent.put("current_url", url);
            urlContent.put("html", p);
            urlContent.put("base64_image", base64ScreenShot);
            Document document = new Document();
            document.append("_id",i+1).put("seed_url",rootURL);
            document.append("_id",i+1).put("current_url",url);
            document.append("_id",i+1).put("html",p);
            document.append("_id",i+1).put("base64_image",base64ScreenShot);
            col.insertOne(document);
            try {
                FileWriter file = new FileWriter("C:\\Users\\vaibh\\webCrawler\\src\\main\\java\\OutputDataJSON\\"+OutputJSON+"\\"+domainName+i+".json");
                file.write(urlContent.toJSONString());
                file.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
            driver.close();
       }
    }
}
