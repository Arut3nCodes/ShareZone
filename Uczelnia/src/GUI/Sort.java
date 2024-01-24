package GUI;

import Osoba.Student;

import javax.swing.*;

public class Sort {
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    int choice;

    public Sort(){
        String[] Strings = {"Po nazwiskach", "Po nazwiskach i imionach", "Po nazwiskach i wieku"};
        JComboBox<String> cb = new JComboBox<>(Strings);

        p.add(new JLabel("Wybierz w jaki sposob sortowac"));
        p.add(cb);

        int result = JOptionPane.showConfirmDialog(null, p,
                "Sortowanie", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            choice = cb.getSelectedIndex() + 1;
            System.out.print(choice);
        }

        else if(result == JOptionPane.OK_CANCEL_OPTION){
            choice = 0;
        }
    }
}
