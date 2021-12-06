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
            for (Element movieElement : movies) {

                Movie m1 = new Movie();
                List<String> genresList = new ArrayList<>();
                String movie = movieElement.select("div.lister-item-content").first().getElementsByTag("h3").first().select("a").text();
                String rankString = movieElement.select("div.lister-item-content").first().getElementsByTag("h3").first().select("span.lister-item-index.unbold.text-primary").text();
                String yearString = movieElement.select("div.lister-item-content").first().getElementsByTag("h3").first().select("span.lister-item-year.text-muted.unbold").text();
                String certificate = movieElement.select("div.lister-item-content").first().getElementsByTag("p").first().select("span.certificate").text();
                String imdbRatingString = movieElement.select("div.lister-item-content").first().select("div.ipl-rating-widget > div.ipl-rating-star.small > span.ipl-rating-star__rating").text();
                String metascoreString = movieElement.select("div.lister-item-content").first().select("div.inline-block.ratings-metascore > span.metascore.favorable").text();
                String movieUrlString = movieElement.select("div.lister-item-image.ribbonize > a").attr("href");
                String yearNoBraces = yearString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                String rankCleaned = rankString.replaceAll("[^0-9]", " ").replaceAll("\\s", "");
                String movieUrl = "imdb.com"+movieUrlString;


                Elements genres = movieElement.select("div.lister-item-content").first().getElementsByTag("p").first().select("span.genre");
                for(Element g: genres){
                    genresList.add(g.text());
                }
                int year = Integer.parseInt(yearNoBraces);
                int rank = Integer.parseInt(rankCleaned);
                float imdbRatingScrap = 0.0f;
                int metascoreScrap = 0;
                if(!imdbRatingString.equals("")) {
                    imdbRatingScrap = Float.parseFloat(imdbRatingString);
                }
                if(!metascoreString.equals("")){
                    metascoreScrap = Integer.parseInt(metascoreString);
                }

                m1.setName(movie);
                m1.setRank(rank);
                m1.setReleaseYear(year);
                m1.setCertificate(certificate);
                m1.setGenre(genresList);
                m1.setImdbRating(imdbRatingScrap);
                m1.setMetaScore(metascoreScrap);
                m1.setMoviePageUrl(movieUrl);
                movieTopList.put(rank, m1);

            }

        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (Map.Entry<Integer, Movie> movieSet : movieTopList.entrySet()) {
            System.out.println("("+movieSet.getKey()+")" + " ------> " + movieSet.getValue().toString()+ "\n\n");
        }
    }
}
