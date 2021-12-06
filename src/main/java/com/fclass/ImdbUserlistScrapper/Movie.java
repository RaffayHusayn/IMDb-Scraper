package com.fclass.ImdbUserlistScrapper;

import java.util.List;

public class Movie {
    String name; //name of the movie
    int releaseYear; //year of release of the movie
    int rank; // not applicable in most cases
    String certificate; // the rating that movie got eg: R, PG-13 etc
    List<String> genre; // List of Genres
    float imdbRating;
    int metaScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }


    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getMetaScore() {
        return metaScore;
    }

    public void setMetaScore(int metaScore) {
        this.metaScore = metaScore;
    }

    @Override
    public String toString() {
        return name + "( "+ releaseYear + " ) \n "+ certificate + " | "
                + genre + " | Stars: "+imdbRating+ "| Metascore : "+metaScore  ;
    }
}
