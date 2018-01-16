package com.mojafirma.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPanel extends JFrame{

    public MenuPanel() throws HeadlessException {
        iniMenuPanel();
    }

    private void iniMenuPanel() {
        setTitle("Menu Główne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocation(100, 100);

        setVisible(true);

        GridLayout gridLayout = new GridLayout(1,2);
        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
        add(panel);

        JButton goToClientPanel = new JButton();
        goToClientPanel.setText("Panel Klienta");
        goToClientPanel.setBackground(Color.BLACK);
        goToClientPanel.setForeground(Color.WHITE);
        goToClientPanel.setFont(new Font("Consolas", Font.BOLD, 20));

        JButton goToAdminPanel = new JButton();
        goToAdminPanel.setText("Panel Administratora");
        goToAdminPanel.setBackground(Color.WHITE);
        goToAdminPanel.setForeground(Color.BLACK);
        goToAdminPanel.setFont(new Font("Consolas", Font.BOLD, 20));
        panel.add(goToClientPanel);
        panel.add(goToAdminPanel);

        goToClientPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ClientPanel clientPanel = new ClientPanel();
            }
        });

        goToAdminPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminPanel adminPanel = new AdminPanel();
            }
        });
    }
}
