package com.mojafirma.presenter.view;

import com.mojafirma.model.Movie;
import com.mojafirma.presenter.MoviePresenter;

import java.time.LocalDate;
import java.util.List;

public class MovieView implements MoviePresenter {

    @Override
    public List<Movie> showMovieList() {
        return movieDao.getMovieList();
    }

    @Override
    public Movie getMovie(int id) {
        Movie movie = movieDao.getMovie(id);
        return movie;
    }

    @Override
    public void addMovie() {
        movieDao.addMovie(addingMovie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieDao.deleteMovie(movie);
    }

    @Override
    public void setTitleAddingMovie(String title) {
        addingMovie.setTitle(title);
    }

    @Override
    public void setYearAddingMovie(LocalDate year) {
        addingMovie.setYear(year);
    }

    @Override
    public void setDurationAddingMovie(int duration) {
        addingMovie.setDuration(duration);
    }

    @Override
    public void setDirectorAddingMovie(String director) {
        addingMovie.setDirector(director);
    }
}


