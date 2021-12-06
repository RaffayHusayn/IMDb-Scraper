package com.fclass.ImdbUserlistScrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImdbScrapper {
   public void top50List(){
        Map<Integer, List<String>> movieRankList = new HashMap<>();
        Map<Integer, String> movieYearList = new HashMap<>();

        try {
            Document doc = Jsoup.connect("https://www.imdb.com/list/ls098795660/?ref_=tt_rls_1").get();
            Elements movies = doc.select("div.lister-item.mode-detail");
            for(Element movieElement : movies.select("div.lister-item-content"))
            {

                List<String> movieAndYear = new ArrayList<>();
                List<String> genresList = new ArrayList<>();
                String movie = movieElement.getElementsByTag("h3").first().select("a").text();
                String rankString = movieElement.getElementsByTag("h3").first().select("span.lister-item-index.unbold.text-primary").text();
                String yearString = movieElement.getElementsByTag("h3").first().select("span.lister-item-year.text-muted.unbold").text();
                String imdbRatingString = movieElement.select("div.ipl-rating-widget > div.ipl-rating-star.small > span.ipl-rating-star__rating").text();
                String metascore = movieElement.select("div.inline-block.ratings-metascore > span.metascore.favorable").text();
                String yearNoBraces = yearString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                String rankCleaned = rankString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                String certificate = movieElement.getElementsByTag("p").first().select("span.certificate").text();
                Elements genres = movieElement.getElementsByTag("p").first().select("span.genre");
                for(Element g: genres){
                    genresList.add(g.text());
                }
                int year = Integer.parseInt(yearNoBraces);
                int rank = Integer.parseInt(rankCleaned);
                movieAndYear.add(movie);
                movieAndYear.add(yearNoBraces);
                movieAndYear.add(certificate);
                movieAndYear.add(imdbRatingString);
                movieAndYear.add(metascore);

                movieRankList.put(rank, movieAndYear);
//                System.out.println(genresList);
//                System.out.println(movie);
//                System.out.println(rank);
//                System.out.println(year);
            }

        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(Map.Entry<Integer , List<String>> movieSet: movieRankList.entrySet()){
            System.out.println(movieSet.getKey() + " ------> "+ movieSet.getValue());
        }
    }


}
