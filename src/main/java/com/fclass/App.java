package com.fclass;

import com.fclass.ImdbUserlistScrapper.ImdbScrapper;
import com.fclass.ImdbUserlistScrapper.ImdbUserListScrapper;
import com.fclass.ImdbUserlistScrapper.StringCleaning;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        ImdbUserListScrapper movieList = new ImdbUserListScrapper();
        movieList.scrapImdbUserList("https://www.imdb.com/list/ls098795660/?ref_=tt_rls_1");
//
//        ImdbScrapper top50 = new ImdbScrapper();
//        top50.top50List();
////
//        List<String> directorList = new ArrayList<>();
//        List<String> castList = new ArrayList<>();
//        StringCleaning sc = new StringCleaning();
//        sc.directorAndCastSplitor("Directors: Ethan Coen, Joel Coen | Stars: Tommy Lee Jones, Javier Bardem, Josh Brolin, Woody Harrelson",directorList,castList);
//        System.out.println("Director");
//        for(String d:directorList){
//            System.out.println(d);
//        }
//        System.out.println("cast");
//        for(String d:castList){
//            System.out.println(d);
        }


    }


