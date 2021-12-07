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
            String starsString = moviePageDoc.select("div.AggregateRatingButton__Rating-sc-1ll29m0-2.bmbYRW > span").first().text();

            String[] yearAndRatingArray = stringCleaning.yearAndRating(TvOrMovieFlag,certificateAndYearString);
            int releaseYear= Integer.parseInt(yearAndRatingArray[0]);
            String certificate=yearAndRatingArray[1];


            List<String> genres = new ArrayList<>();
            Elements genreList = moviePageDoc.select("a.GenresAndPlot__GenreChip-cum89p-3.fzmeux.ipc-chip.ipc-chip--on-baseAlt > span.ipc-chip__text");
            for(Element e: genreList){
                genres.add(e.text());
            }

//            Elements directorList = moviePageDoc.select("ul.ipc-inline-list.ipc-inline-list--show-dividers.ipc-inline-list--inline.ipc-metadata-list-item__list-content.base > li.ipc-inline-list__item > a.ipc-metadata-list-item__list-content-item.ipc-metadata-list-item__list-content-item--link");
//            Elements directorListNew = moviePageDoc.select("section.ipc-page-section.ipc-page-section--base.StyledComponents__CastSection-y9ygcu-0.fswvJC.celwidget > ul.ipc-inline-list.ipc-inline-list--show-dividers.ipc-inline-list--inline.ipc-metadata-list-item__list-content.base > li").first().select("li.ipc-inline-list__item");
            Elements directorList2 = moviePageDoc.select("ul.ipc-metadata-list.ipc-metadata-list--dividers-all.StyledComponents__CastMetaDataList-y9ygcu-10.cbPPkN.ipc-metadata-list--base > li").first().select("ul").first().select("li");
            System.out.println("director list printing now");
            for(Element e: directorList2){
                System.out.println(e.select("a").text());
            }


            //crew and cast string : li.ipc-inline-list__item
            System.out.println("genres : "+ genres);
            System.out.println(TvOrMovieFlag);
            System.out.println(movie);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
