package com.mojafirma.presenter;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.ShowingDao;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowingPresenter {

    ShowingDao showingDao = new ShowingDao();
    Showing addingShowing = new Showing();

    Showing getShowing(Integer showingId);

    List<Showing> getShowings();

    void addShowing();

    void setMovieAddingShowing(Movie movie);

    void setDateTimeAddingShowing(LocalDateTime dateTime);

    void setRoomAddingShowing(int roomNumber);

    void deleteShowing(Showing showing);
}
