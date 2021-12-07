package com.fclass;

import com.fclass.ImdbMoviePage.ImdbMoviePageScraper;
import com.fclass.ImdbMoviePage.ImdbMovieTest;
import com.fclass.ImdbUserlist.ImdbUserListScraper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

//        ImdbMovieTest moviePage = new ImdbMovieTest();
//        moviePage.scrapImdbMoviePage("https://www.imdb.com/title/tt2402927/?ref_=tt_sims_tt_t_1");

//        ImdbMovieTest moviePage = new ImdbMovieTest();
//        moviePage.scrapImdbMoviePage("https://www.imdb.com/title/tt0903747/?ref_=fn_al_tt_1");

//        ImdbMoviePageScraper moviePageClass = new ImdbMoviePageScraper();
//        moviePageClass.scrapImdbMoviePage("https://www.imdb.com/title/tt0903747/?ref_=fn_al_tt_1");

        ImdbMoviePageScraper moviePageClass = new ImdbMoviePageScraper();
        moviePageClass.scrapImdbMoviePage("https://www.imdb.com/title/tt2402927/?ref_=tt_sims_tt_t_1");

        /*
        This returns a Hashmap<Integer, Movie> , This link is for TV shows User List
         */
//        ImdbUserListScraper movieList = new ImdbUserListScraper();
//        movieList.scrapImdbUserList("https://www.imdb.com/list/ls039658291/?ref_=rltls_37");




        /*
        This returns a Hashmap<Integer, Movie> , This link is for Movie User List
         */

//        ImdbUserListScrapper movieList = new ImdbUserListScrapper();
//        movieList.scrapImdbUserList("https://www.imdb.com/list/ls098795660/?ref_=tt_rls_1");

        /*
        This returns Hashmap<Integer, List<String>>
         */
//        ImdbScrapper top50 = new ImdbScrapper();
//        top50.top50List();




    }


}


