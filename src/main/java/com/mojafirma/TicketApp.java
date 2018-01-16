package com.mojafirma;


import com.mojafirma.model.Ticket;
import com.mojafirma.model.dao.ShowingDao;
import com.mojafirma.model.dao.TicketDao;
import com.mojafirma.util.HibernateUtil;

public class TicketApp {

    public static void main(String[] args) {

        TicketDao ticketDao = new TicketDao();
        ShowingDao showingDao = new ShowingDao();
        Ticket ticket = new Ticket();

        ticket.setShowing(showingDao.getShowing(1));
        ticket.setUser_name("Bartosz");
        ticket.setUser_last_name("Jańczak");
        ticket.setSeat(11);
        ticketDao.addTicket(ticket);

        HibernateUtil.getSessionFactory().close();
    }
}
