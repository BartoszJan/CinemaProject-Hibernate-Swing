package com.mojafirma.util;

import com.mojafirma.model.Ticket;

import javax.swing.*;
import java.util.List;

/**
 * Created by Bartek on 2017-11-11.
 */
public class TicketListModel extends AbstractListModel<Ticket>{

    private List<Ticket> tickets;

    public TicketListModel(List<Ticket> showings) {
        this.tickets = showings;
    }

    @Override
    public int getSize() {
        return tickets.size();
    }

    @Override
    public Ticket getElementAt(int index) {
        return tickets.get(index);
    }

}