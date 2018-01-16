package com.mojafirma.model.dao;

import com.mojafirma.model.Ticket;
import com.mojafirma.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDao {

    public Integer addTicket(Ticket ticket) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ticketID = null;
        try {
            tx = session.beginTransaction();
            ticketID = (Integer) session.save(ticket);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ticketID;
    }

    public Ticket getTicket(Integer ticketId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Ticket ticket = null;
        try {
            tx = session.beginTransaction();
            ticket = session.get(Ticket.class, ticketId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return ticket;
    }

    public List<Ticket> getTicketList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Ticket> tickets = null;
        try {
            tx = session.beginTransaction();
            tickets = session.createQuery("FROM Ticket").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return tickets;
    }

    public void deleteTicket(Ticket ticket) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(ticket);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
