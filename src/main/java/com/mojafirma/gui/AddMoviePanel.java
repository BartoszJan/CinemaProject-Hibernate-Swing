package com.mojafirma.gui;

import com.mojafirma.presenter.view.MovieView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddMoviePanel extends JFrame{

    private JPanel panel1;
    private JTextField headTextField;
    private JTextField textField1;
    private JTextField movieTitleInput;
    private JTextField textField3;
    private JTextField yearInput;
    private JTextField textField5;
    private JTextField durationInput;
    private JTextField textField7;
    private JTextField directorInput;
    private JButton button1;
    private JButton backButton;

    public AddMoviePanel() { iniAddMoviePanel(); }

    MovieView movieView = new MovieView();

    private void iniAddMoviePanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(500, 500);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String movieTitle = movieTitleInput.getText();
                LocalDate yearMovie = LocalDate.parse(yearInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int duration = Integer.parseInt(durationInput.getText());
                String director = directorInput.getText();

                movieView.setTitleAddingMovie(movieTitle);
                movieView.setYearAddingMovie(yearMovie);
                movieView.setDurationAddingMovie(duration);
                movieView.setDirectorAddingMovie(director);
                movieView.addMovie();
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
    }
}