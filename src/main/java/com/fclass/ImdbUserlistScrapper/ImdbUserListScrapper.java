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

public class ImdbUserListScrapper {
    String ImdbUserListURL;
    public void scrapImdbUserList(String ImdbUserListURL) {
        this.ImdbUserListURL = ImdbUserListURL;
        Map<Integer, Movie> movieTopList = new HashMap<>();

        try {
            Document doc = Jsoup.connect(ImdbUserListURL).get();
            Elements movies = doc.select("div.lister-item.mode-detail");
            for (Element movieElement : movies.select("div.lister-item-content")) {

                Movie m1 = new Movie();
                List<String> genresList = new ArrayList<>();
                String movie = movieElement.getElementsByTag("h3").first().select("a").text();
                String rankString = movieElement.getElementsByTag("h3").first().select("span.lister-item-index.unbold.text-primary").text();
                String yearString = movieElement.getElementsByTag("h3").first().select("span.lister-item-year.text-muted.unbold").text();
                String certificate = movieElement.getElementsByTag("p").first().select("span.certificate").text();
                String yearNoBraces = yearString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                String rankCleaned = rankString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");

                Elements genres = movieElement.getElementsByTag("p").first().select("span.genre");
                for(Element g: genres){
                    genresList.add(g.text());
                }
                int year = Integer.parseInt(yearNoBraces);
                int rank = Integer.parseInt(rankCleaned);
                m1.setName(movie);
                m1.setRank(rank);
                m1.setReleaseYear(year);
                m1.setCertificate(certificate);
                m1.setGenre(genresList);
                movieTopList.put(rank, m1);

            }

        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        System.out.println(movieRankList.get(1));
//        System.out.println(movieRankList.get(3));
        for (Map.Entry<Integer, Movie> movieSet : movieTopList.entrySet()) {
            System.out.println("("+movieSet.getKey()+")" + " ------> " + movieSet.getValue().toString()+ "\n\n");
        }
    }
}
