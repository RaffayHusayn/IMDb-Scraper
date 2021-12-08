package com.fclass;

import javax.persistence.*;
import java.util.List;
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    @Column(name = "movieName" , nullable=true)
    String name; //name of the movie
    @Column(name = "movieReleaseYear" , nullable=true)
    int releaseYear; //year of release of the movie
    @Column(name = "movieRank" ,nullable=true)
    int rank; // not applicable in most cases
    @Column(name = "movieCertificate" , nullable=true)
    String certificate; // the rating that movie got eg: R, PG-13 etc
    @Column(nullable=true)
    @ElementCollection
    List<String> genre; // List of Genres
    @Column(nullable=true)
    float imdbRating; //imdb star ratings
    @Column(name="movieMetascore" , nullable=true)
    int metaScore; //metascore , if 0 means the score wasn't avaible
    @Column(name = "moviePageUrl", nullable=true)
    String moviePageUrl; //url to imdb page of the movie
    @Column(nullable=true)
    @ElementCollection
    List<String> cast; // list of cast members
    @Column(nullable=true)
    @ElementCollection
    List<String> directors; //list of directors, usually one but can be more
    String description;

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

    public String getMoviePageUrl() {
        return moviePageUrl;
    }

    public void setMoviePageUrl(String moviePageUrl) {
        this.moviePageUrl = moviePageUrl;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " ( "+ releaseYear + " )"+
                " \n "+ certificate + " | " + genre + " | Stars: "+imdbRating+ "| Metascore : "+metaScore+
                "\n Director : "+ directors+ "    |  Cast : "+ cast +
                " \n Movie Url : "+ moviePageUrl +
                "\n Synopsis : "+ description;
    }
}
