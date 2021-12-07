package com.fclass.ImdbMoviePage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieTest {
    String ImdbMoviePageURL;
    public void scrapImdbMoviePage(String ImdbMoviePageUrl){
        this.ImdbMoviePageURL = ImdbMoviePageUrl;
        try {
            Document moviePageDoc = Jsoup.connect(ImdbMoviePageUrl).get();
            String movie = moviePageDoc.select("h1.TitleHeader__TitleText-sc-1wu6n3d-0.dxSWFG").text();
            String TvOrMovieFlag = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").first().text();
            String certificateAndYearString = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").text();
            StringCleaningMoviePage stringCleaning = new StringCleaningMoviePage();

            String[] yearAndRatingArray = stringCleaning.yearAndRating(TvOrMovieFlag,certificateAndYearString);
            int releaseYear= Integer.parseInt(yearAndRatingArray[0]);
            String certificate=yearAndRatingArray[1];


            List<String> genres = new ArrayList<>();
            Elements genreList = moviePageDoc.select("a.GenresAndPlot__GenreChip-cum89p-3.fzmeux.ipc-chip.ipc-chip--on-baseAlt > span.ipc-chip__text");
            System.out.println("genre list printing now");
            for(Element e: genreList){
                genres.add(e.text());
            }
            System.out.println("genres : "+ genres);
            System.out.println(TvOrMovieFlag);
            System.out.println(movie);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
