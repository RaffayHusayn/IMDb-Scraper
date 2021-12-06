package com.fclass;

import com.fclass.MovieScrapper.ImdbScrapper;
import com.fclass.MovieScrapper.ImdbScrapperMovie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        ImdbScrapperMovie movieList = new ImdbScrapperMovie();
        movieList.getTop50List();


        }
    }

