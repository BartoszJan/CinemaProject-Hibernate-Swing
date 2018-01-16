package com.mojafirma.util;

import com.mojafirma.model.Showing;

import javax.swing.*;
import java.util.List;

public class ShowingListModel extends AbstractListModel<Showing> {

    private List<Showing> showings;

    public ShowingListModel(List<Showing> showings) {
        this.showings = showings;
    }

    @Override
    public int getSize() {
        return showings.size();
    }

    @Override
    public Showing getElementAt(int index) {
        return showings.get(index);
    }

}
