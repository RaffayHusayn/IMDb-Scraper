package com.fclass.ImdbMoviePage;

public class StringCleaningMoviePage {
    public int isMovieOrShow(String movieOrShowString){
        /*
        Returns 1 if it's a movie and returns 0 if it's a TV show
         */
        if(movieOrShowString.equals("TV Series")){
            System.out.println("it is Tv show");
            return 0;
        }else{
            System.out.println("it is movie");
            return 1;
        }
    }

    public String[] yearAndRating(String movieOrShowFlag, String yearAndRatingString){
        int movieOrshow = isMovieOrShow(movieOrShowFlag);
        if(movieOrshow == 1){
            String[] split = yearAndRatingString.split("\\s+", 3);

            String releaseYear = split[0].substring(0,(split[0].length()/2));
            String certificate = split[1].substring(0,(split[1].length()/2));
            String[] movieResult = {releaseYear, certificate};
            return movieResult;
        }else if(movieOrshow == 0){
            System.out.println(yearAndRatingString);
            String[] split = yearAndRatingString.split("\\s",5 );
            System.out.println(split[2]);// return -> 2007–20192007–2019
            System.out.println(split[3]); // returns -> TV-PGTV-PG
            String year = split[2].substring(0,4);
            String certificate = split[3].substring(0, split[3].length()/2);
            System.out.println("-----the year is : "+ year);
            return new String[] {year, certificate};
        }
        else return new String[]{"nothing"};

    }

}
