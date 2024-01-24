package GUI;

import Kurs.Kurs;
import Osoba.*;
import Uczelnia.Uczelnia;
import Wyszukiwanie.WyszukiwaniePracownicy;
import Wyszukiwanie.WyszukiwanieStudenci;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class FindPerson implements ActionListener {
    Uczelnia u;
    JFrame f = new JFrame();
    JDialog jd;
    JPanel p = new JPanel();
    JComboBox<String> cb, cb1, cb2;
    int choice1;
    int choice2;
    String choice3;

    public FindPerson(Uczelnia u){
        this.u = u;
        String[] Strings = {"...", "Student", "Pracownik"};
        cb = new JComboBox<>(Strings);
        cb1 = new JComboBox<>();
        cb2 = new JComboBox<>();
        cb.addActionListener(this);
        cb1.addActionListener(this);
        p.add(new JLabel("Wybierz po czym wyszukujesz kurs"));
        p.add(cb);
        p.add(cb1);
        p.add(cb2);
        cb1.addItem("");
        cb2.addItem("");

        cb.setPreferredSize(new Dimension(200, 25));
        cb.setMinimumSize(new Dimension(200, 25));
        cb.setMaximumSize(new Dimension(200, 25));

        cb1.setPreferredSize(new Dimension(100, 25));
        cb1.setMinimumSize(new Dimension(100, 25));
        cb1.setMaximumSize(new Dimension(100, 25));

        cb2.setPreferredSize(new Dimension(100, 25));
        cb2.setMinimumSize(new Dimension(100, 25));
        cb2.setMaximumSize(new Dimension(100, 25));

        int result = JOptionPane.showConfirmDialog(null, p,
                "Wyszukiwanie", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            choice1 = cb.getSelectedIndex();
            choice2 = cb1.getSelectedIndex();
            choice3 = (String)cb2.getSelectedItem();
            pokazWyszukiwanie();
        }

        else if(result == JOptionPane.OK_CANCEL_OPTION){
        }
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == cb){
            if(cb.getSelectedIndex() == 1) {
                String[] OptionsS =  {"...", "Imie", "Nazwisko", "Wiek", "Nr indeksu"};
                cb1.removeAllItems();
                for(String s: OptionsS){
                    cb1.addItem(s);
                }
            }

            else if(cb.getSelectedIndex() == 2) {
                String[] OptionsP =  {"...","Imie", "Nazwisko", "Wiek", "Staz pracy"};
                cb1.removeAllItems();
                for(String s: OptionsP){
                    cb1.addItem(s);
                }
            }
        }

        if(event.getSource() == cb1){
            if(cb.getSelectedIndex() == 1) {
                if(cb1.getSelectedIndex() == 1){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof Student) Options.add(o.getImie());
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }

                else if(cb1.getSelectedIndex() == 2){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof Student)Options.add(o.getNazwisko());
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }

                else if(cb1.getSelectedIndex() == 3){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof Student) Options.add(String.valueOf(o.getWiek()));
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }

                else if(cb1.getSelectedIndex() == 4){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof Student) Options.add(String.valueOf(((Student)o).getNrIndeksu()));
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }
            }

            else if(cb.getSelectedIndex() == 2) {
                if(cb1.getSelectedIndex() == 1){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof PracownikUczelni) Options.add(o.getImie());
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }

                else if(cb1.getSelectedIndex() == 2){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof PracownikUczelni) Options.add(o.getNazwisko());
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }

                else if(cb1.getSelectedIndex() == 3){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof PracownikUczelni) Options.add(String.valueOf(o.getWiek()));
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }

                else if(cb1.getSelectedIndex() == 4){
                    HashSet<String> Options = new HashSet<>();
                    for(Osoba o: u.Osoby){
                        if(o instanceof PracownikUczelni) Options.add(String.valueOf(((PracownikUczelni)o).getStazPracy()));
                    }
                    cb2.removeAllItems();
                    for(String s: Options){
                        cb2.addItem(s);
                    }
                }
            }
        }
    }

    public void pokazWyszukiwanie(){
        jd = new JDialog(f, "Wyszukiwanie");
        DefaultListModel<Osoba> model = new DefaultListModel<>();
        JList<Osoba> jt = new JList<>(model);
        WyszukiwanieStudenci ws = new WyszukiwanieStudenci();
        WyszukiwaniePracownicy wp = new WyszukiwaniePracownicy();
        ArrayList<Osoba> alk;
        jd.setSize(1200, 300);
        jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jd.setResizable(false);
        jd.setLocationRelativeTo(null);
        jd.add(new JScrollPane(jt));


        if(choice1 == 1){
            switch(choice2){
                case 1: {
                    alk = ws.wyszukajPoImieniuStudenta(choice3, u);

                    break;
                }
                case 2: {
                    alk = ws.wyszukajPoNazwiskuStudenta(choice3, u);
                    break;
                }
                case 3: {
                    alk = ws.wyszukajPoWiekuStudenta(Integer.parseInt(choice3), u);
                    break;
                }
                case 4: {
                    alk = ws.wyszukajPoNrIndeksu(Integer.parseInt(choice3), u);
                    break;
                }
                default:{
                    alk = new ArrayList<>();
                    break;
                }
            }
        }

        else if(choice1 == 2){
            switch(choice2){
                case 1:{
                    alk = wp.wyszukajPoImieniuPracownika(choice3, u);
                    break;
                }

                case 2: {
                    alk = wp.wyszukajPoNazwiskuPracownika(choice3, u);
                    break;
                }

                case 3: {
                    alk = wp.wyszukajPoWiekuPracownika(Integer.parseInt(choice3), u);
                    break;
                }

                case 4: {
                    alk = wp.wyszukajPoStazuPracownika(Integer.parseInt(choice3), u);
                    break;
                }

                default:{
                    alk = new ArrayList<Osoba>();
                    break;
                }

                }
            }

        else alk = new ArrayList<Osoba>();

        for(Osoba o: alk){
            model.addElement(o);
        }

        jd.setVisible(true);


    }
}
