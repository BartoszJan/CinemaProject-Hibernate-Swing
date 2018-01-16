package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.model.Ticket;
import com.mojafirma.presenter.view.MovieView;
import com.mojafirma.presenter.view.ShowingView;
import com.mojafirma.presenter.view.TicketView;
import com.mojafirma.util.MovieComboBoxModel;
import com.mojafirma.util.ShowingListModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TicketReservationPanel extends JFrame {
    private JList showingsList;
    private JTextField textField2;
    private JButton bookTicketButton;
    private JTextField textField3;
    private JRadioButton a45RadioButton;
    private JRadioButton a35RadioButton;
    private JRadioButton a55RadioButton;
    private JRadioButton a36RadioButton;
    private JRadioButton a46RadioButton;
    private JRadioButton a56RadioButton;
    private JRadioButton a37RadioButton;
    private JRadioButton a47RadioButton;
    private JRadioButton a57RadioButton;
    private JRadioButton a38RadioButton;
    private JRadioButton a48RadioButton;
    private JRadioButton a58RadioButton;
    private JRadioButton a67RadioButton;
    private JRadioButton a68RadioButton;
    private JRadioButton a66RadioButton;
    private JRadioButton a65RadioButton;
    private JTextField textField1;
    private JComboBox movieChooserBox;
    private JTextField textField4;
    private JRadioButton a34RadioButton;
    private JRadioButton a43RadioButton;
    private JRadioButton a44RadioButton;
    private JRadioButton a54RadioButton;
    private JRadioButton a64RadioButton;
    private JRadioButton a63RadioButton;
    private JRadioButton a53RadioButton;
    private JRadioButton a33RadioButton;
    private JRadioButton a32RadioButton;
    private JRadioButton a42RadioButton;
    private JRadioButton a52RadioButton;
    private JRadioButton a62RadioButton;
    private JRadioButton a22RadioButton;
    private JRadioButton a23RadioButton;
    private JRadioButton a24RadioButton;
    private JRadioButton a25RadioButton;
    private JRadioButton a28RadioButton;
    private JRadioButton a27RadioButton;
    private JRadioButton a26RadioButton;
    private JRadioButton a21RadioButton;
    private JRadioButton a11RadioButton;
    private JRadioButton a31RadioButton;
    private JRadioButton a41RadioButton;
    private JRadioButton a51RadioButton;
    private JRadioButton a61RadioButton;
    private JRadioButton a12RadioButton;
    private JRadioButton a13RadioButton;
    private JRadioButton a14RadioButton;
    private JRadioButton a15RadioButton;
    private JRadioButton a16RadioButton;
    private JRadioButton a17RadioButton;
    private JRadioButton a18RadioButton;
    private JRadioButton a19RadioButton;
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTextField userNameTextField;
    private JTextField userLastNameTextField;
    private JTextField textField7;
    private JTextField textField8;
    private JButton backButton;

    public TicketReservationPanel() { iniTicketReservationPanel(); }

    MovieView movieView = new MovieView();
    TicketView ticketView = new TicketView();
    ShowingView showingView = new ShowingView();

    private void iniTicketReservationPanel() {

        setContentPane(mainPanel);
        pack();
        setTitle("Rezerwacja biletów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(700, 400);
        setVisible(true);

        movieView.showMovieList();

        movieChooserBox.setModel(new MovieComboBoxModel(movieView.showMovieList()));
        movieChooserBox.setRenderer(new BasicComboBoxRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null) {
                    Movie movie = (Movie) value;
                    setText(movie.getTitle());
                }
                return this;
            }
        });

        movieChooserBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = (Movie) movieChooserBox.getSelectedItem();
                if (!showingsList.getValueIsAdjusting()) {
                    List<Showing> showingsByDate = movie.getShowings().stream().sorted((e1, e2) -> e1.getShowing_date_time().compareTo(e2.getShowing_date_time()))
                            .collect(Collectors.toList());
                    showingsList.setModel(new ShowingListModel(showingsByDate));
                }
            }
        });

        showingsList.setCellRenderer(new ListCellRenderer<Showing>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Showing> list, Showing value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel(value.getShowing_date_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString() + " Nr sali: " + value.getRoom_number());
                listItem.setOpaque(true);
                if (isSelected)

                {
                    listItem.setBackground(list.getSelectionBackground());
                    listItem.setForeground(list.getSelectionForeground());
                } else {
                    listItem.setBackground(list.getBackground());
                    listItem.setForeground(list.getForeground());
                }
                listItem.setFont(list.getFont());
                listItem.setEnabled(list.isEnabled());
                listItem.setMinimumSize(new Dimension(100, 20));
                return listItem;
            }
        });

        ArrayList<JRadioButton> allRadioButtons = new ArrayList<>();
        for (int i = 0; i < panel2.getComponents().length; i++) {
            allRadioButtons.add((JRadioButton) panel2.getComponents()[i]);
        }

        ButtonGroup seats = new ButtonGroup();

        for (int i = 0; i < allRadioButtons.size(); i++) {
            seats.add(allRadioButtons.get(i));
        }

        showingsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<Showing> showingsList = (JList<Showing>) e.getSource();

                Showing selectedShowing = showingsList.getSelectedValue();
                ticketView.setShowingAddingTicket(selectedShowing);

                if (!e.getValueIsAdjusting() && !showingsList.isSelectionEmpty()) {

                    List<Ticket> bookedTickets = showingView.getShowing(selectedShowing.getShowing_id()).getTickets();

                    for (int i = 0; i < allRadioButtons.size(); i++) {
                        allRadioButtons.get(i).setEnabled(true);
                        allRadioButtons.get(i).setBackground(Color.GREEN);
                        seats.clearSelection();
                    }

                    for (int i = 0; i < bookedTickets.size(); i++) {
                        for (int j = 0; j < allRadioButtons.size(); j++) {
                            if (bookedTickets.get(i).getSeat() == Integer.parseInt(allRadioButtons.get(j).getText())) {
                                allRadioButtons.get(j).setEnabled(false);
                                allRadioButtons.get(j).setBackground(Color.RED);
                            }
                        }
                    }
                }
            }
        });

        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticketView.setUserNameAddingTicket(userNameTextField.getText());
                ticketView.setUserLastNameAddingTicket(userLastNameTextField.getText());

                for (int i = 0; i < allRadioButtons.size(); i++) {
                    if (allRadioButtons.get(i).isSelected()) {
                        ticketView.setSeatAddingTicket(Integer.parseInt(allRadioButtons.get(i).getText()));
                        allRadioButtons.get(i).setEnabled(false);
                        allRadioButtons.get(i).setBackground(Color.RED);
                        break;
                    }
                }
                ticketView.addTicket();
                seats.clearSelection();

            }
        });

        backButton.setText("← Wróć Do Panelu Klienta");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Consolas", Font.BOLD, 15));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientPanel clientPanel = new ClientPanel();
            }
        });
    }
}