package com.fclass.ImdbMoviePage;

import com.fclass.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ImdbMoviePageScraper {
    String ImdbMoviePageURL;
    public void scrapImdbMoviePage(String ImdbMoviePageUrl){
        this.ImdbMoviePageURL = ImdbMoviePageUrl;
        StringCleaningMoviePage stringCleaning = new StringCleaningMoviePage();
        Movie m1 = new Movie();

        try {
            Document moviePageDoc = Jsoup.connect(ImdbMoviePageUrl).get();
            String movie = moviePageDoc.select("h1.TitleHeader__TitleText-sc-1wu6n3d-0.dxSWFG").text();
            String TvOrMovieFlag = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").first().text();
            String certificateAndYearString = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").text();

            String[] yearAndRatingArray = stringCleaning.yearAndRating(TvOrMovieFlag,certificateAndYearString);
            int releaseYear= Integer.parseInt(yearAndRatingArray[0]);
            String certificate=yearAndRatingArray[1];

            m1.setName(movie);
            m1.setReleaseYear(releaseYear);
            m1.setCertificate(certificate);

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(m1.toString());
    }
}
