package com.fclass;

import com.fclass.ImdbMoviePage.ImdbMoviePageScraper;
import com.fclass.ImdbMoviePage.ImdbMovieTest;
import com.fclass.ImdbUserlist.ImdbUserListScraper;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        /*
          This returns a single MOVIE OBJECT
       */
//        ImdbMoviePageScraper moviePageClass = new ImdbMoviePageScraper();
//        Movie m1 = moviePageClass.scrapImdbMoviePage("https://www.imdb.com/title/tt0903747/?ref_=fn_al_tt_1");
//        System.out.println(m1.toString());
//
//        /*
//        Printing to CSV file of a single movie object at a time
//        */
//        CSVWriter csvWriter = new CSVWriter();
//        csvWriter.save("csvfile.csv", false,  m1);
//
//        /*
//        Saving to the database of a single movie object
//         */
//        DatabaseWriter dbWriter = new DatabaseWriter();
//        Session s1 = dbWriter.startHibernateSession();
//        dbWriter.persistMovie(s1, m1);





        /*=======================================================*/




        /*
        This returns a Hashmap<Integer, Movie> , This link is for Movie User List
         */
//
        ImdbUserListScraper movieList = new ImdbUserListScraper();
        Map<Integer, Movie> movieListMap = movieList.scrapImdbUserList("https://www.imdb.com/list/ls079342176/");

        CSVWriter csvWriter = new CSVWriter();
        PrintWriter printWriter = csvWriter.saveOrAppend("csvfile.csv", true);
        DatabaseWriter databaseWriter = new DatabaseWriter();
        Session s1 = databaseWriter.startHibernateSession();


        for (Map.Entry<Integer, Movie> movieSet : movieListMap.entrySet()) {
            csvWriter.save(printWriter , movieSet.getValue());
            databaseWriter.persistMovie(s1, movieSet.getValue());
            System.out.println("("+movieSet.getKey()+")" + " ------> " + movieSet.getValue().toString()+ "\n\n");
        }
        csvWriter.closeCSVWriter(printWriter);
        databaseWriter.closeHibernateSession(s1);







        /*
        This returns Hashmap<Integer, List<String>>
         */
//        ImdbScrapper top50 = new ImdbScrapper();
//        top50.top50List();




    }


}


