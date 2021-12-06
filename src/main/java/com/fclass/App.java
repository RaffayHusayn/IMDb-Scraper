package com.fclass;

import com.fclass.ImdbUserlistScrapper.ImdbUserListScrapper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        /*
        This returns a Hashmap<Integer, Movie>
         */
        ImdbUserListScrapper movieList = new ImdbUserListScrapper();
        movieList.scrapImdbUserList("https://www.imdb.com/list/ls098795660/?ref_=tt_rls_1");

        /*
        This returns Hashmap<Integer, List<String>>
         */
//        ImdbScrapper top50 = new ImdbScrapper();
//        top50.top50List();




    }


}


