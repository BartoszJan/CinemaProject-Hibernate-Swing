package com.mojafirma.presenter;

import com.mojafirma.model.Movie;
import com.mojafirma.model.dao.MovieDao;

import java.time.LocalDate;
import java.util.List;

public interface MoviePresenter {

    MovieDao movieDao = new MovieDao();
    Movie addingMovie = new Movie();

    List<Movie> showMovieList();

    Movie getMovie(int id);

    void addMovie();

    void deleteMovie(Movie movie);

    void setTitleAddingMovie(String title);

    void setYearAddingMovie(LocalDate year);

    void setDurationAddingMovie(int duration);

    void setDirectorAddingMovie(String director);
}
