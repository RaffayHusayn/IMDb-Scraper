package com.fclass.ImdbMoviePage;

public class StringCleaningMoviePage {
    public int isMovieOrShow(String movieOrShowString){
        /*
        Returns 1 if it's a movie and returns 0 if it's a TV show
         */
        if(movieOrShowString.equals("TV Series")){
            return 0;
        }else{
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
            String[] split = yearAndRatingString.split("\\s",5 );
            String year = split[2].substring(0,4);
            String certificate = split[3].substring(0, split[3].length()/2);
            return new String[] {year, certificate};
        }
        else return new String[]{"nothing"};

    }

    public int setMetascore(String movieOrShowFlag , String metascoreString){
        int movieOrShow = isMovieOrShow(movieOrShowFlag);
        if(movieOrShow == 1 && (!metascoreString.equals(""))){
            return Integer.parseInt(metascoreString);
        }else{
            return 0;
        }
    }

}
