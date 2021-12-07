package com.fclass.ImdbMoviePage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ImdbMovieTest {
    String ImdbMoviePageURL;
    public void scrapImdbMoviePage(String ImdbMoviePageUrl){
        this.ImdbMoviePageURL = ImdbMoviePageUrl;
        try {
            Document moviePageDoc = Jsoup.connect(ImdbMoviePageUrl).get();
            String movie = moviePageDoc.select("h1.TitleHeader__TitleText-sc-1wu6n3d-0.dxSWFG").text();
            String TvOrMovieFlag = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").first().text();
            String certificateAndYearString = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").text();
            System.out.println(certificateAndYearString);
            StringCleaningMoviePage stringCleaning = new StringCleaningMoviePage();

            String[] yearAndRatingArray = stringCleaning.yearAndRating(TvOrMovieFlag,certificateAndYearString);
            int releaseYear= Integer.parseInt(yearAndRatingArray[0]);
            String certificate=yearAndRatingArray[1];
            System.out.println("=====Release Year :"+ releaseYear);
            System.out.println("=======certificate :"+ certificate);
            System.out.println(TvOrMovieFlag);
            System.out.println(movie);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
