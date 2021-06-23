package tech.codingclub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.codingclub.utility.HttpURLConnectionExample;
import tech.codingclub.utility.TaskManager;

public class wikipediaDownloader implements  Runnable{

    public String keyword;




    wikipediaDownloader(String keyword)
    {
        this.keyword  = keyword;

    }

    public void run() {

        //1.Clean The Code
        //2.Get the URL for wikipedia
        //3.make a get request to wikipedia
        //4.parsing the useful results using jsoup
        //5.Displaying the results


        if(this.keyword == null || this.keyword.length()==0)
            return ;
        this.keyword = this.keyword.trim().replaceAll("[ ]+","_");

        int state = 0 ;
        String imageUrl = null;
        String response="";
        String wikiUrl = getWikiUrl(this.keyword);
        try {
            String urlResponse = HttpURLConnectionExample.sendGet(wikiUrl);
            //System.out.println(urlResponse);


            Document document = Jsoup.parse(urlResponse,"https://en.wikipedia.org");
            Elements childElements = document.body().select(".mw-parser-output > *");

            for(Element childElement : childElements)
            {
                if(state==0)
                {
                    if(childElement.tagName().equals("table"))
                    {
                        state =1;
                    }
                }
                else if(state==1)
                {
                    if(childElement.tagName().equals("p"))
                    {
                        state = 2;
                        response=childElement.text();
                        break;
                    }
                }


            }

        try{

            imageUrl = document.body().select(".infobox img").get(0).attr("src");

        }catch (Exception ex){

        }


        } catch (Exception e) {
            e.printStackTrace();
        }

        wikiResult Wiki = new wikiResult(this.keyword,response,imageUrl);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();


        System.out.println(gson.toJson(Wiki));



    }

    private String getWikiUrl(String keyword) {

        return "https://en.wikipedia.org/wiki/" + this.keyword;
    }

    public static void main(String[] args) throws InterruptedException {

        TaskManager taskmanager = new TaskManager(1);


        String arr[] = {"Albert Einstein", "Sachin Tendulkar"};

        for (String keyword : arr) {

            wikipediaDownloader x = new wikipediaDownloader(keyword);
            taskmanager.waitTillQueueIsFreeAndAddTask(x);


        }
    }


}
