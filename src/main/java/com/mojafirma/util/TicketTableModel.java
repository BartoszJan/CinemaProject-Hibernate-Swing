package com.mojafirma.util;

import com.mojafirma.model.Ticket;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TicketTableModel extends AbstractTableModel {

    private List<Ticket> tickets;

    private String[] columnName = new String[] {"Id", "Imię", "Nazwisko", "Seans", "Miejsce"};

    public TicketTableModel(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public int findColumn(String columnName) {
        return findColumn(columnName);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public int getRowCount() {
        return tickets.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column].toString();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String result = "";
        switch (columnIndex) {
            case 0: {
                result = String.valueOf(tickets.get(rowIndex).getTicket_id());
                break;
            }
            case 1: {
                result = tickets.get(rowIndex).getUser_name().toString();
                break;
            }
            case 2: {
                result = tickets.get(rowIndex).getUser_last_name().toString();
                break;
            }
            case 3: {
                result = tickets.get(rowIndex).getShowing().getMovie().getTitle() + " " + tickets.get(rowIndex).getShowing().getShowing_date_time()
                        + " Sala " + tickets.get(rowIndex).getShowing().getRoom_number();
                break;
            }
            case 4: {
                result = String.valueOf(tickets.get(rowIndex).getSeat());
                break;
            }
        }
        return result;
    }
}
