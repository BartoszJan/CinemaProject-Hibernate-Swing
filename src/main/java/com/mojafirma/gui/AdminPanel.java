package com.mojafirma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {


    public AdminPanel() throws HeadlessException {
        iniAdminPanel();
    }

    private void iniAdminPanel() {

        setTitle("Panel Administratora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocation(100, 100);

        setVisible(true);

        GridLayout gridLayout = new GridLayout(3,2);
        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);

        JButton goToAddMoviePanel = new JButton();
        goToAddMoviePanel.setText("Dodaj Film Do Bazy");
        goToAddMoviePanel.setBackground(Color.BLACK);
        goToAddMoviePanel.setForeground(Color.WHITE);
        goToAddMoviePanel.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton goToAddShowingPanel = new JButton();
        goToAddShowingPanel.setText("Dodaj Seans Do Bazy");
        goToAddShowingPanel.setBackground(Color.WHITE);
        goToAddShowingPanel.setForeground(Color.BLACK);
        goToAddShowingPanel.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton goToDeleteMoviePanel = new JButton();
        goToDeleteMoviePanel.setText("Usuń Film Z Bazy");
        goToDeleteMoviePanel.setBackground(Color.WHITE);
        goToDeleteMoviePanel.setForeground(Color.BLACK);
        goToDeleteMoviePanel.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton goToDeleteShowingPanel = new JButton();
        goToDeleteShowingPanel.setText("Usuń Seans Z Bazy");
        goToDeleteShowingPanel.setBackground(Color.BLACK);
        goToDeleteShowingPanel.setForeground(Color.WHITE);
        goToDeleteShowingPanel.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton goToDeleteTicketPanel = new JButton();
        goToDeleteTicketPanel.setText("Usuń Rezerwację Z Bazy");
        goToDeleteTicketPanel.setBackground(Color.BLACK);
        goToDeleteTicketPanel.setForeground(Color.WHITE);
        goToDeleteTicketPanel.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton backButton = new JButton();
        backButton.setText("← Wróć Do Menu");
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Consolas", Font.BOLD, 15));

        goToAddMoviePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddMoviePanel addMoviePanel = new AddMoviePanel();
            }
        });

        goToAddShowingPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddShowingPanel addShowingPanel = new AddShowingPanel();
            }
        });

        goToDeleteMoviePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeleteMoviePanel deleteMoviePanel = new DeleteMoviePanel();
            }
        });

        goToDeleteShowingPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeleteShowingPanel deleteShowingPanel = new DeleteShowingPanel();
            }
        });

        goToDeleteTicketPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DeleteTicketPanel deleteTicketPanel = new DeleteTicketPanel();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPanel menuPanel = new MenuPanel();
            }
        });

        panel.add(goToAddMoviePanel,0);
        panel.add(goToAddShowingPanel,1);
        panel.add(goToDeleteMoviePanel,2);
        panel.add(goToDeleteShowingPanel,3);
        panel.add(goToDeleteTicketPanel,4);

        BorderLayout borderLayout = new BorderLayout();
        add(panel, borderLayout.CENTER);
        add(backButton, borderLayout.SOUTH);
    }
}
