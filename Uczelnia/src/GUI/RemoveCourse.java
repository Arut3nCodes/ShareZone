package GUI;

import Kurs.Kurs;
import Uczelnia.Uczelnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class RemoveCourse implements ActionListener {
    Uczelnia u;
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JComboBox<String> cb, cb1, cb2;
    int choice1;
    String choice2;

    public RemoveCourse(Uczelnia u){
        this.u = u;
        String[] Strings = {"","Po nazwie kursu", "Po nazwisku prowadzacego", "Po punktach ECTS"};
        cb = new JComboBox<>(Strings);
        cb1 = new JComboBox<>();
        cb.addActionListener(this);
        p.add(new JLabel("Wybierz po czym usuwasz kurs"));
        p.add(cb);
        p.add(cb1);
        cb1.addItem("");

        cb.setPreferredSize(new Dimension(200, 25));
        cb.setMinimumSize(new Dimension(200, 25));
        cb.setMaximumSize(new Dimension(200, 25));

        cb1.setPreferredSize(new Dimension(200, 25));
        cb1.setMinimumSize(new Dimension(200, 25));
        cb1.setMaximumSize(new Dimension(200, 25));

        int result = JOptionPane.showConfirmDialog(null, p,
                "Usuwanie", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            choice1 = cb.getSelectedIndex();
            choice2 =  ((String)cb1.getSelectedItem());
            System.out.println((String)cb1.getSelectedItem());
        }

        else if(result == JOptionPane.OK_CANCEL_OPTION){
            choice1 = 0;
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cb){

            if(cb.getSelectedIndex() == 1) {
                HashSet<String> Options = new HashSet<>();
                for(Kurs k: u.Kursy){
                    Options.add(k.getNazwaKursu());
                }
                cb1.removeAllItems();
                for(String o: Options){
                    cb1.addItem(o);
                }
            }

            else if(cb.getSelectedIndex() == 2) {
                HashSet<String> Options = new HashSet<>();
                for(Kurs k: u.Kursy){
                    Options.add(k.getNazwiskoProwadzacego());
                }
                cb1.removeAllItems();
                for(String o: Options){
                    cb1.addItem(o);
                }
            }

            else if(cb.getSelectedIndex() == 3) {
                    HashSet<String> Options = new HashSet<>();
                for(Kurs k: u.Kursy){
                    Options.add(String.valueOf(k.getPunktyETC()));
                }
                cb1.removeAllItems();
                for(String o: Options){
                    cb1.addItem(o);
                }
            }

            else{
                cb1.removeAllItems();
                cb1.addItem("bozo");
            }
        }
    }

}
