package com.mojafirma.presenter;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.model.dao.TicketDao;

import java.util.List;

public interface TicketPresenter {

    TicketDao ticketDao = new TicketDao();
    Ticket addingTicket = new Ticket();

    void addTicket();

    Ticket getTicket(int ticketId);

    List<Ticket> getTickets();

    void deleteTicket(Ticket ticket);

    void setShowingAddingTicket(Showing showing);

    void setUserNameAddingTicket(String name);

    void setUserLastNameAddingTicket(String lastName);

    void setSeatAddingTicket(int seatNumber);
}
