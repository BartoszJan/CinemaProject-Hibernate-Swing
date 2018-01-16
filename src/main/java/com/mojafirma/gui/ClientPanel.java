package com.mojafirma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientPanel extends JFrame{


    public ClientPanel() throws HeadlessException {
        iniClientPanel();
    }

    private void iniClientPanel() {
        setTitle("Serwis Obsługi Kina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocation(100, 100);

        setVisible(true);

        BorderLayout borderLayout = new BorderLayout();
        GridLayout gridLayout = new GridLayout(1,2);
        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
        add(panel, borderLayout.CENTER);

        JButton goToShowingCheckout = new JButton();
        goToShowingCheckout.setText("Sprawdź Seanse");
        goToShowingCheckout.setBackground(Color.BLACK);
        goToShowingCheckout.setForeground(Color.WHITE);
        goToShowingCheckout.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton goToTicketReservation = new JButton();
        goToTicketReservation.setText("Rezerwacja biletów");
        goToTicketReservation.setBackground(Color.WHITE);
        goToTicketReservation.setForeground(Color.BLACK);
        goToTicketReservation.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton backButton = new JButton();
        backButton.setText("← Wróć Do Menu");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Consolas", Font.BOLD, 15));

        panel.add(goToShowingCheckout);
        panel.add(goToTicketReservation);
        add(backButton, borderLayout.SOUTH);

        goToShowingCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ShowingCheckoutPanel showingCheckoutPanel = new ShowingCheckoutPanel();
            }
        });

        goToTicketReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TicketReservationPanel ticketReservationPanel = new TicketReservationPanel();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPanel menuPanel = new MenuPanel();
            }
        });
    }
}
