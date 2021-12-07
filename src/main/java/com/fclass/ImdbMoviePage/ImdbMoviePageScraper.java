package com.fclass.ImdbMoviePage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ImdbMoviePageScraper {
    String ImdbMoviePageURL;
    public void scrapImdbMoviePage(String ImdbMoviePageUrl){
        this.ImdbMoviePageURL = ImdbMoviePageUrl;
        try {
            Document moviePageDoc = Jsoup.connect(ImdbMoviePageUrl).get();
            String movie = moviePageDoc.select("h1.TitleHeader__TitleText-sc-1wu6n3d-0.dxSWFG").text();





        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
