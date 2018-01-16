package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.presenter.view.MovieView;
import com.mojafirma.util.MovieComboBoxModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMoviePanel extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JComboBox chooseMovieComboBox;
    private JButton deleteMovieButton;
    private JButton backButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField yearTextField;
    private JTextField textField6;
    private JTextField durationTextField;
    private JTextField textField7;
    private JTextField directorTextField;

    public DeleteMoviePanel() { iniDeleteMoviePanel(); }

    MovieView movieView = new MovieView();

    private void iniDeleteMoviePanel() {

        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(500, 500);
        setVisible(true);

        chooseMovieComboBox.setModel(new MovieComboBoxModel(movieView.showMovieList()));
        chooseMovieComboBox.setRenderer(new BasicComboBoxRenderer(){
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value != null){
                    Movie movie = (Movie) value;
                    setText(movie.getTitle());
                }
                return this;
            }
        });

        chooseMovieComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie selectedMovie = (Movie)chooseMovieComboBox.getSelectedItem();
                yearTextField.setText(selectedMovie.getYear().toString());
                directorTextField.setText(selectedMovie.getDirector());
                durationTextField.setText(String.valueOf(selectedMovie.getDuration()));
            }
        });

        deleteMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie selectedMovie = (Movie)chooseMovieComboBox.getSelectedItem();
                movieView.deleteMovie(selectedMovie);
                chooseMovieComboBox.setModel(new MovieComboBoxModel(movieView.showMovieList()));
                yearTextField.setText("");
                durationTextField.setText("");
                directorTextField.setText("");
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
