package com.mojafirma.presenter.view;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.presenter.ShowingPresenter;

import java.time.LocalDateTime;
import java.util.List;

public class ShowingView implements ShowingPresenter{

    @Override
    public Showing getShowing(Integer showingId) {
        return showingDao.getShowing(showingId);
    }

    @Override
    public List<Showing> getShowings() {
        return showingDao.getShowingList();
    }

    @Override
    public void addShowing() {
        showingDao.addShowing(addingShowing);
    }

    @Override
    public void setMovieAddingShowing(Movie movie) {
        addingShowing.setMovie(movie);
    }

    @Override
    public void setDateTimeAddingShowing(LocalDateTime dateTime) {
        addingShowing.setShowing_date_time(dateTime);
    }

    @Override
    public void setRoomAddingShowing(int roomNumber) {
        addingShowing.setRoom_number(roomNumber);
    }

    @Override
    public void deleteShowing(Showing showing) {
        showingDao.deleteShowing(showing);
    }
}
