package com.mojafirma.model.dao;

import com.mojafirma.util.HibernateUtil;
import com.mojafirma.model.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MovieDao {

    public Integer addMovie(Movie movie) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer movieID = null;
        try {
            tx = session.beginTransaction();
            movieID = (Integer) session.save(movie);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return movieID;
    }

    public Movie getMovie(Integer movieId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Movie movie = null;
        try {
            tx = session.beginTransaction();
            movie = session.get(Movie.class, movieId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return movie;
    }

    public List<Movie> getMovieList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Movie> movies = null;
        try {
            tx = session.beginTransaction();
            movies = session.createQuery("FROM Movie").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return movies;
    }

    public void deleteMovie(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(movie);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
