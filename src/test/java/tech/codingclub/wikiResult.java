package tech.codingclub;

public class wikiResult {

    public String query;
    public String text_result;
    public String image_url;

    public wikiResult(String query,String text_result,String image_url)
    {
        this.image_url=image_url;
        this.text_result=text_result;
        this.query=query;
    }

}
