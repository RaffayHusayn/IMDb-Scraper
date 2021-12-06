package com.fclass.MovieScrapper;

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
            Document doc = Jsoup.connect("http://www.imdb.com/list/ls055386972/").get();
            Elements movies = doc.select("div.lister-item.mode-detail");
            for(Element movieElement : movies.select("div.lister-item-content"))
            {

                List<String> movieAndYear = new ArrayList<>();
                String movie = movieElement.getElementsByTag("h3").first().select("a").text();
                String rankString = movieElement.getElementsByTag("h3").first().select("span.lister-item-index.unbold.text-primary").text();
                String yearString = movieElement.getElementsByTag("h3").first().select("span.lister-item-year.text-muted.unbold").text();
                String yearNoBraces = yearString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                String rankCleaned = rankString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                int year = Integer.parseInt(yearNoBraces);
                int rank = Integer.parseInt(rankCleaned);
                movieAndYear.add(movie);
                movieAndYear.add(yearNoBraces);
                movieRankList.put(rank, movieAndYear);

//                System.out.println(movie);
//                System.out.println(rank);
//                System.out.println(year);
            }

        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        System.out.println(movieRankList.get(1));
//        System.out.println(movieRankList.get(3));
        for(Map.Entry<Integer , List<String>> movieSet: movieRankList.entrySet()){
            System.out.println(movieSet.getKey() + " ------> "+ movieSet.getValue());
        }
    }


}
