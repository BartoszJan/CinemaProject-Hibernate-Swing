package com.mojafirma.gui;

import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.presenter.view.ShowingView;
import com.mojafirma.presenter.view.TicketView;
import com.mojafirma.util.ShowingListModel;
import com.mojafirma.util.TicketTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteTicketPanel extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox chooseSortingComboBox;
    private JTextField textField2;
    private JList chooseShowingList;
    private JButton deleteShowingButton;
    private JButton backButton;
    private JTextField textField3;
    private JTable ticketTable;
    private JList chooseClientList;
    private JScrollPane clientListScroll;
    private JScrollPane showingListScroll;

    public DeleteTicketPanel(){ iniDeleteTicketPanel(); }

    ShowingView showingView = new ShowingView();
    TicketView ticketView = new TicketView();

    private void iniDeleteTicketPanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(700, 600);
        setVisible(true);

        chooseSortingComboBox.addItem("Tytułu Filmów");
        chooseSortingComboBox.addItem("Daty Seansów");
        chooseSortingComboBox.addItem("Klientów");

        chooseSortingComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chooseSortingComboBox.getSelectedItem() == "Tytułu Filmów") {
                    chooseShowingList.clearSelection();
                    chooseShowingList.setEnabled(true);
                    chooseClientList.setEnabled(false);

                    textField2.setText("Wybierz Seans");

                    List<Showing> showingsSortByMovie = showingView.getShowings().stream()
                            .sorted((e1, e2) -> e1.getMovie().getTitle().compareTo(e2.getMovie().getTitle())).collect(Collectors.toList());

                    chooseShowingList.setModel(new ShowingListModel(showingsSortByMovie));
                    chooseShowingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    chooseShowingList.setCellRenderer(new ListCellRenderer<Showing>() {
                        @Override
                        public Component getListCellRendererComponent(JList<? extends Showing> list, Showing value, int index, boolean isSelected, boolean cellHasFocus) {
                            JLabel listItem = new JLabel(value.getMovie().getTitle() + " // " + value.getShowing_date_time()
                                    + " Sala nr:  " + value.getRoom_number());
                            listItem.setOpaque(true);
                            if (isSelected)

                            {
                                listItem.setBackground(list.getSelectionBackground());
                                listItem.setForeground(list.getSelectionForeground());
                            }
                            else
                            {
                                listItem.setBackground(list.getBackground());
                                listItem.setForeground(list.getForeground());
                            }
                            listItem.setFont(list.getFont());
                            listItem.setEnabled(list.isEnabled());
                            listItem.setMinimumSize(new Dimension(100, 20));
                            return listItem;
                        }
                    });

                    chooseShowingList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting() && !chooseShowingList.isSelectionEmpty()) {
                                Showing chosenShowing = (Showing) chooseShowingList.getSelectedValue();
                                ticketTable.setModel(new TicketTableModel(chosenShowing.getTickets()));
                                ticketTable.getColumnModel().getColumn(3).setPreferredWidth(300);
                            }
                        }
                    });
                }

                if (chooseSortingComboBox.getSelectedItem() == "Daty Seansów") {
                    chooseShowingList.clearSelection();
                    chooseShowingList.setEnabled(true);
                    chooseClientList.setEnabled(false);

                    textField2.setText("Wybierz Seans");

                    List<Showing> showingsByDate = showingView.getShowings().stream()
                            .sorted((e1, e2) -> e1.getShowing_date_time().compareTo(e2.getShowing_date_time())).collect(Collectors.toList());
                    chooseShowingList.setModel(new ShowingListModel(showingsByDate));

                    chooseShowingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    chooseShowingList.setCellRenderer(new ListCellRenderer<Showing>() {
                        @Override
                        public Component getListCellRendererComponent(JList<? extends Showing> list, Showing value, int index, boolean isSelected, boolean cellHasFocus) {
                            JLabel listItem = new JLabel(value.getShowing_date_time() + " Sala nr:  " + value.getRoom_number()
                                    + " // " + value.getMovie().getTitle());
                            listItem.setOpaque(true);
                            if (isSelected)

                            {
                                listItem.setBackground(list.getSelectionBackground());
                                listItem.setForeground(list.getSelectionForeground());
                            }
                            else
                            {
                                listItem.setBackground(list.getBackground());
                                listItem.setForeground(list.getForeground());
                            }
                            listItem.setFont(list.getFont());
                            listItem.setEnabled(list.isEnabled());
                            listItem.setMinimumSize(new Dimension(100, 20));
                            return listItem;
                        }
                    });

                    chooseShowingList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if (!e.getValueIsAdjusting() && !chooseShowingList.isSelectionEmpty()) {
                                Showing chosenShowing = (Showing) chooseShowingList.getSelectedValue();
                                ticketTable.setModel(new TicketTableModel(chosenShowing.getTickets()));
                                ticketTable.getColumnModel().getColumn(3).setPreferredWidth(300);
                            }
                        }
                    });
                }

                if (chooseSortingComboBox.getSelectedItem() == "Klientów") {
                    chooseClientList.setEnabled(true);
                    chooseShowingList.setEnabled(false);
                    textField2.setText("Wybierz Klienta");

                    List<Ticket> tickets = ticketView.getTickets();
                    List<String> ticketsClients = new ArrayList<>();
                    String temp;
                    for (int i = 0; i < tickets.size(); i++) {
                        temp = tickets.get(i).getUser_name() + " " + tickets.get(i).getUser_last_name();
                        if (!ticketsClients.contains(temp)) {
                            ticketsClients.add(temp);
                        }
                    }

                    DefaultListModel defaultListModel = new DefaultListModel();
                    for (int i = 0; i < ticketsClients.size(); i++) {
                        defaultListModel.addElement(ticketsClients.get(i));
                    }
                    chooseClientList.setModel(defaultListModel);
                    chooseClientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    chooseClientList.setCellRenderer(new DefaultListCellRenderer());

                    chooseClientList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {

                            if (!e.getValueIsAdjusting() && !chooseClientList.isSelectionEmpty()) {

                                String chosenClient = chooseClientList.getSelectedValue().toString();
                                String[] splitClientString = chosenClient.split(" ");
                                String clientName = splitClientString[0];
                                String clientLastName = splitClientString[1];

                                List<Ticket> clientTickets = new ArrayList<>();
                                List<Ticket> allTickets = ticketView.getTickets();
                                for (int i = 0; i < allTickets.size(); i++) {
                                    if (allTickets.get(i).getUser_name().contains(clientName) && allTickets.get(i).getUser_last_name().contains(clientLastName)) {
                                        clientTickets.add(allTickets.get(i));
                                    }
                                }

                                ticketTable.setModel(new TicketTableModel(clientTickets));
                                ticketTable.getColumnModel().getColumn(3).setPreferredWidth(300);
                            }
                        }
                    });
                }
            }
        });

        backButton.setText("← Wróć Do Panelu Administratora");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Consolas", Font.BOLD, 15));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminPanel adminPanel = new AdminPanel();
            }
        });

        deleteShowingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTicketId = Integer.parseInt(ticketTable.getValueAt(ticketTable.getSelectedRow(), 0).toString());
                ticketView.deleteTicket(ticketView.getTicket(selectedTicketId));

                if (chooseSortingComboBox.getSelectedItem().toString() == "Tytułu Filmów" || chooseSortingComboBox.getSelectedItem().toString() == "Daty Seansów") {
                    Showing chosenShowing = (Showing) chooseShowingList.getSelectedValue();
                    ticketTable.setModel(new TicketTableModel(showingView.getShowing(chosenShowing.getShowing_id()).getTickets()));
                    ticketTable.getColumnModel().getColumn(3).setPreferredWidth(300);
                } else {
                    String chosenClient = chooseClientList.getSelectedValue().toString();
                    String[] splitClientString = chosenClient.split(" ");
                    String clientName = splitClientString[0];
                    String clientLastName = splitClientString[1];

                    List<Ticket> clientTickets = new ArrayList<>();
                    List<Ticket> allTickets = ticketView.getTickets();
                    for (int i = 0; i < allTickets.size(); i++) {
                        if (allTickets.get(i).getUser_name().contains(clientName) && allTickets.get(i).getUser_last_name().contains(clientLastName)) {
                            clientTickets.add(allTickets.get(i));
                        }
                    }

                    ticketTable.setModel(new TicketTableModel(clientTickets));
                    ticketTable.getColumnModel().getColumn(3).setPreferredWidth(300);
                }
            }
        });
    }
}
