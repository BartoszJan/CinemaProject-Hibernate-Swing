package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.presenter.view.MovieView;
import com.mojafirma.presenter.view.ShowingView;
import com.mojafirma.util.MovieComboBoxModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddShowingPanel extends JFrame {
    private JPanel panel1;

    private JTextField headTextField;
    private JTextField textField3;
    private JTextField dateTimeInput;
    private JTextField textField2;
    private JTextField roomNumberInput;
    private JButton button1;
    private JTextField textField1;
    private JComboBox chooseMovieComboBox;
    private JButton backButton;

    public AddShowingPanel(){ iniAddShowingPanel(); }

    MovieView movieView = new MovieView();
    ShowingView showingView = new ShowingView();

    private void iniAddShowingPanel() {

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

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        LocalDateTime dateTimeShowing = LocalDateTime.parse(dateTimeInput.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        int roomNumber = Integer.parseInt(roomNumberInput.getText());

                        Movie movie = (Movie) chooseMovieComboBox.getSelectedItem();
                        showingView.setMovieAddingShowing(movie);
                        showingView.setDateTimeAddingShowing(dateTimeShowing);
                        showingView.setRoomAddingShowing(roomNumber);
                        showingView.addShowing();
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

