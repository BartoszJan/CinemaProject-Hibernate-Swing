package com.mojafirma.gui;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Showing;
import com.mojafirma.presenter.view.MovieView;
import com.mojafirma.presenter.view.ShowingView;
import com.mojafirma.util.MovieComboBoxModel;
import com.mojafirma.util.ShowingListModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteShowingPanel extends JFrame{
    private JPanel panel1;
    private JButton backButton;
    private JTextField textField1;
    private JComboBox chooseMovieComboBox;
    private JTextField textField2;
    private JList chooseShowingList;
    private JButton deleteShowingButton;

    public DeleteShowingPanel() {iniDeleteShowingPanel();}

    ShowingView showingView = new ShowingView();

    MovieView movieView = new MovieView();
    private void iniDeleteShowingPanel() {

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
                Movie choosingMovie = (Movie) chooseMovieComboBox.getSelectedItem();
                if (!chooseShowingList.getValueIsAdjusting()) {
                    List<Showing> showingsByDate = choosingMovie.getShowings().stream().sorted((e1, e2) -> e1.getShowing_date_time().compareTo(e2.getShowing_date_time()))
                            .collect(Collectors.toList());
                    chooseShowingList.setModel(new ShowingListModel(showingsByDate));
                }
            }
        });

        chooseShowingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        chooseShowingList.setCellRenderer(new ListCellRenderer<Showing>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Showing> list, Showing value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel listItem = new JLabel(value.getShowing_date_time().format(DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss")).toString() + " Nr sali: " + value.getRoom_number());
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

        deleteShowingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Showing showing = (Showing) chooseShowingList.getSelectedValue();
                showingView.deleteShowing(showing);
                chooseShowingList.clearSelection();
                Movie selectedMovie = (Movie) chooseMovieComboBox.getSelectedItem();
                chooseMovieComboBox.setSelectedItem(selectedMovie);
                chooseShowingList.setModel(new ShowingListModel(movieView.getMovie(selectedMovie.getMovie_id()).getShowings()));
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
