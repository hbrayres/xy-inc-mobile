package br.com.zup.filmesimdb.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.Table;

import java.io.Serializable;

/**
 * Created by heber.junior on 11/03/2016.
 */
public class Filme extends SugarRecord implements Serializable {

    private String imdbID;
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Released")
    private String released;
    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Director")
    private String director;
    @SerializedName("Writer")
    private String writer;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Language")
    private String language;
    @SerializedName("Country")
    private String country;
    @SerializedName("Awards")
    private String awards;
    @SerializedName("Poster")
    private String poster;
    private String imdbRating;

    @Ignore
    @SerializedName("Response")
    private boolean response;

    @Ignore
    @SerializedName("Error")
    private String error;

    public Filme() {
    }

    public Filme(final String nome, final String ano) {
        title = nome;
        year = ano;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(final Long id) {
        super.setId(id);
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(final String poster) {
        this.poster = poster;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
