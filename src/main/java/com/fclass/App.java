package com.fclass;

import com.fclass.ImdbMoviePage.ImdbMoviePageScraper;
import com.fclass.ImdbMoviePage.ImdbMovieTest;
import com.fclass.ImdbUserlist.ImdbUserListScraper;
import org.hibernate.Session;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

            //TEST: (AVENGERS)
//        ImdbMovieTest moviePage = new ImdbMovieTest();
//        moviePage.scrapImdbMoviePage("https://www.imdb.com/title/tt4154756/?ref_=tt_sims_tt_t_12");

            //TEST : (BREAKING BAD)
//        ImdbMovieTest moviePage = new ImdbMovieTest();
//        moviePage.scrapImdbMoviePage("https://www.imdb.com/title/tt0903747/?ref_=fn_al_tt_1");








          //  MOVIE OBJECT : (BREAKING BAD)
        ImdbMoviePageScraper moviePageClass = new ImdbMoviePageScraper();
        Movie m1 = moviePageClass.scrapImdbMoviePage("https://www.imdb.com/title/tt0903747/?ref_=fn_al_tt_1");
        System.out.println(m1.toString());


        CSVWriter csvWriter = new CSVWriter();
        csvWriter.save("csvfile.csv", false,  m1);


        DatabaseWriter dbWriter = new DatabaseWriter();
        Session s1 = dbWriter.startHibernateSession();
        dbWriter.persistMovie(s1, m1);











        // MOVIE OBJECT : (AVENGERS)
//        ImdbMoviePageScraper moviePageClass = new ImdbMoviePageScraper();
//        moviePageClass.scrapImdbMoviePage("https://www.imdb.com/title/tt4154756/?ref_=tt_sims_tt_t_12");

//        ImdbMoviePageScraper moviePageClass = new ImdbMoviePageScraper();
//        moviePageClass.scrapImdbMoviePage("https://www.imdb.com/title/tt2402927/?ref_=tt_sims_tt_t_1");

        /*
        This returns a Hashmap<Integer, Movie> , This link is for TV shows User List
         */
//        ImdbUserListScraper movieList = new ImdbUserListScraper();
//        movieList.scrapImdbUserList("https://www.imdb.com/list/ls039658291/?ref_=rltls_37");




        /*
        This returns a Hashmap<Integer, Movie> , This link is for Movie User List
         */
//
//        ImdbUserListScraper movieList = new ImdbUserListScraper();
//        movieList.scrapImdbUserList("https://www.imdb.com/list/ls098795660/?ref_=tt_rls_1");

        /*
        This returns Hashmap<Integer, List<String>>
         */
//        ImdbScrapper top50 = new ImdbScrapper();
//        top50.top50List();




    }


}


