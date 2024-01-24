package GUI;

import Kurs.Kurs;
import Uczelnia.Uczelnia;
import Wyszukiwanie.WyszukiwanieKursy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class FindCourse implements ActionListener {
    Uczelnia u;
    JFrame f = new JFrame();
    JDialog jd;
    JPanel p = new JPanel();
    JComboBox<String> cb, cb1, cb2;
    int choice1;
    String choice2;

    public FindCourse(Uczelnia u){
        this.u = u;
        String[] Strings = {"","Po nazwie kursu","Po imieniu prowadzacego", "Po nazwisku prowadzacego", "Po punktach ECTS"};
        cb = new JComboBox<>(Strings);
        cb1 = new JComboBox<>();
        cb.addActionListener(this);
        p.add(new JLabel("Wybierz po czym wyszukujesz kurs"));
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
                "Wyszukiwanie", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            choice1 = cb.getSelectedIndex();
            choice2 =  ((String)cb1.getSelectedItem());
            pokazWyszukiwanie();
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
                    Options.add(k.getImieProwadzacego());
                }
                cb1.removeAllItems();
                for(String o: Options){
                    cb1.addItem(o);
                }
            }

            else if(cb.getSelectedIndex() == 3) {
                HashSet<String> Options = new HashSet<>();
                for(Kurs k: u.Kursy){
                    Options.add(k.getNazwiskoProwadzacego());
                }
                cb1.removeAllItems();
                for(String o: Options){
                    cb1.addItem(o);
                }
            }

            else if(cb.getSelectedIndex() == 4) {
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

    public void pokazWyszukiwanie(){
        jd = new JDialog(f, "Wyszukiwanie");
        DefaultListModel<Kurs> model = new DefaultListModel<>();
        JList<Kurs> jt = new JList<>(model);
        WyszukiwanieKursy wk = new WyszukiwanieKursy();
        ArrayList<Kurs> alk;
        jd.setSize(1200, 300);
        jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jd.setResizable(false);
        jd.setLocationRelativeTo(null);
        jd.add(new JScrollPane(jt));


        switch(choice1){
            case 1: {
                alk = wk.wyszukajPoNazwieKursu(choice2, u);
                break;
            }

            case 2: {
                alk = wk.wyszukajPoImieniuProwadzacego(choice2, u);
                break;
            }

            case 3: {
                alk = wk.wyszukajPoNazwiskuProwadzacego(choice2, u);
                break;
            }

            case 4: {
                alk = wk.wyszukajPoPunktachECTS(Integer.parseInt(choice2), u);
                break;
            }

            default: {
                alk = new ArrayList<>();
                break;
            }
        }

        for(Kurs k: alk){
            model.addElement(k);
        }

        jd.setVisible(true);


    }

}