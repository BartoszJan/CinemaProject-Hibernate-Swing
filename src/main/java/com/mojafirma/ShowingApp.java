package com.mojafirma;

import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.MovieDao;
import com.mojafirma.model.dao.ShowingDao;
import com.mojafirma.util.HibernateUtil;

import java.time.LocalDateTime;

public class ShowingApp {

    public static void main(String[] args) {

        ShowingDao showingDao = new ShowingDao();
        MovieDao movieDao = new MovieDao();
        Showing matrixShowing = new Showing();
        matrixShowing.setMovie(movieDao.getMovie(2));
        matrixShowing.setShowing_date_time(LocalDateTime.of(2017, 10, 16, 21, 15));
        matrixShowing.setRoom_number(1);

        showingDao.addShowing(matrixShowing);
        HibernateUtil.getSessionFactory().close();
    }
}
