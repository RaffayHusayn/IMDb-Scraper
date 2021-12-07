package com.fclass.ImdbMoviePage;

import com.fclass.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImdbMoviePageScraper {
    String ImdbMoviePageURL;
    public void scrapImdbMoviePage(String ImdbMoviePageUrl){
        this.ImdbMoviePageURL = ImdbMoviePageUrl;
        StringCleaningMoviePage stringCleaning = new StringCleaningMoviePage();
        Movie m1 = new Movie();
        List<String> genreList = new ArrayList<>();


        try {
            Document moviePageDoc = Jsoup.connect(ImdbMoviePageUrl).get();
            String movie = moviePageDoc.select("h1.TitleHeader__TitleText-sc-1wu6n3d-0.dxSWFG").text();
            String TvOrMovieFlag = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").first().text();
            String certificateAndYearString = moviePageDoc.select("div.TitleBlock__TitleMetaDataContainer-sc-1nlhx7j-2.hWHMKr > ul").first().select("li ").text();
            String imdbRatingString = moviePageDoc.select("div.AggregateRatingButton__Rating-sc-1ll29m0-2.bmbYRW > span").first().text();
            String metascoreString = moviePageDoc.select("span.score-meta").text();

            String[] yearAndRatingArray = stringCleaning.yearAndRating(TvOrMovieFlag,certificateAndYearString);
            int releaseYear= Integer.parseInt(yearAndRatingArray[0]);
            String certificate=yearAndRatingArray[1];
            int metascore = stringCleaning.setMetascore( metascoreString);
            float imdbRating = Float.parseFloat(imdbRatingString);




            Elements genreElements = moviePageDoc.select("a.GenresAndPlot__GenreChip-cum89p-3.fzmeux.ipc-chip.ipc-chip--on-baseAlt > span.ipc-chip__text");
            for(Element g:genreElements){
                genreList.add(g.text());
            }


            m1.setName(movie);
            m1.setReleaseYear(releaseYear);
            m1.setCertificate(certificate);
            m1.setGenre(genreList);
            m1.setImdbRating(imdbRating);
            m1.setMetaScore(metascore);

        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(m1.toString());
    }
}
