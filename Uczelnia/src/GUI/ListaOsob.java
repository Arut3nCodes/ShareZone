package GUI;

import Kurs.Kurs;
import Osoba.*;
import UI.UI;
import Uczelnia.Uczelnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaOsob extends JSplitPane implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JComboBox<String> cb1;
    DefaultListModel<Osoba> model = new DefaultListModel<>();
    JList<Osoba> list;
    Uczelnia u;
    UI ui;



    public ListaOsob(Uczelnia u1) {
            super();
            this.setDividerLocation(670);
            this.u = u1;
            this.ui = new UI();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setBackground(Color.darkGray);

            list = new JList<>(model);

            this.setLeftComponent(new JScrollPane(list));
            this.setRightComponent(panel);

        b1 = new JButton("Dodaj Studenta");
        b2 = new JButton("Dodaj Pracownika Adm");
        b3 = new JButton("Dodaj Pracownika Bad-Dyd");
        b4 = new JButton("Sortuj");
        b5 = new JButton("Usun");
        b6 = new JButton("Wyszukaj");
        b7 = new JButton("Wczytaj Osoby z pliku");
        b8 = new JButton("Zapisz Osoby do pliku");
        b9 = new JButton("Usun duplikaty");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        b1.setPreferredSize(new Dimension(200, 25));
        b1.setMinimumSize(new Dimension(200, 50));
        b1.setMaximumSize(new Dimension(200, 50));

        b2.setPreferredSize(new Dimension(200, 25));
        b2.setMinimumSize(new Dimension(200, 50));
        b2.setMaximumSize(new Dimension(200, 50));

        b3.setPreferredSize(new Dimension(200, 25));
        b3.setMinimumSize(new Dimension(200, 50));
        b3.setMaximumSize(new Dimension(200, 50));

        b4.setPreferredSize(new Dimension(200, 25));
        b4.setMinimumSize(new Dimension(200, 50));
        b4.setMaximumSize(new Dimension(200, 50));

        b5.setPreferredSize(new Dimension(200, 25));
        b5.setMinimumSize(new Dimension(200, 50));
        b5.setMaximumSize(new Dimension(200, 50));

        b6.setPreferredSize(new Dimension(200, 25));
        b6.setMinimumSize(new Dimension(200, 50));
        b6.setMaximumSize(new Dimension(200, 50));

        b7.setPreferredSize(new Dimension(200, 25));
        b7.setMinimumSize(new Dimension(200, 50));
        b7.setMaximumSize(new Dimension(200, 50));

        b8.setPreferredSize(new Dimension(200, 25));
        b8.setMinimumSize(new Dimension(200, 50));
        b8.setMaximumSize(new Dimension(200, 50));

        b9.setPreferredSize(new Dimension(200, 25));
        b9.setMinimumSize(new Dimension(200, 50));
        b9.setMaximumSize(new Dimension(200, 50));

        panel.add(b1, BorderLayout.LINE_END);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);

        list.setBackground(Color.orange);

        this.setBackground(Color.ORANGE);

    }

    public void actionPerformed(ActionEvent zdarzenie) {
        if (zdarzenie.getSource() == b1) {
            DodajStudenta s = new DodajStudenta();
            model.addElement(s.s);
            u.dodajOsobe(s.s);
        }

        if(zdarzenie.getSource() == b2){
            DodajPracownikaAdm pa = new DodajPracownikaAdm();
            model.addElement(pa.pa);
            u.dodajOsobe(pa.pa);
        }

        if(zdarzenie.getSource() == b3){
            DodajPracownikaBadDyd pbd = new DodajPracownikaBadDyd();
            model.addElement(pbd.pbd);
            u.dodajOsobe(pbd.pbd);
        }
        if(zdarzenie.getSource() == b4){
            Sort s = new Sort();

            switch(s.choice){
                case 1: {
                    u.wypiszWszystkichStudentow();
                    ui.sortowanie.sortowaniePoNazwisku(u);
                    model.removeAllElements();
                    for(Osoba o: u.Osoby){
                        model.addElement(o);
                    }

                    break;
                }
                case 2: {
                    ui.sortowanie.sortowaniePoNazwiskuIImieniu(u);
                    model.removeAllElements();
                    for(Osoba o: u.Osoby){
                        model.addElement(o);
                    }
                    break;
                }
                case 3: {
                    ui.sortowanie.sortowaniePoNazwiskuIWieku(u);
                    model.removeAllElements();
                    for(Osoba o: u.Osoby){
                        model.addElement(o);
                    }

                    break;
                }
            }
        }
        if(zdarzenie.getSource() == b5){
            RemovePerson rp = new RemovePerson(u);

            if(rp.choice1 == 1){
                switch(rp.choice2){
                    case 1: {
                        ui.usuwanie.usuwanieStudentaPoImieniu(u, rp.choice3);

                        break;
                    }
                    case 2: {
                        ui.usuwanie.usuwanieStudentaPoNazwisku(u, rp.choice3);
                        break;
                    }
                    case 3: {
                        ui.usuwanie.usuwanieStudentaPoWieku(u, Integer.parseInt(rp.choice3));
                        break;
                    }
                    case 4: {
                        ui.usuwanie.usuwanieStudentaPoNrIndeksu(u, Integer.parseInt(rp.choice3));
                        break;
                    }
                }
            }

            else if(rp.choice1 == 2){
                switch(rp.choice2){
                    case 1:{
                        ui.usuwanie.usuwaniePracownikaPoImieniu(u, rp.choice3);
                        break;
                    }

                    case 2: {
                        ui.usuwanie.usuwaniePracownikaPoNazwisku(u, rp.choice3);
                        break;
                    }

                    case 3: {
                        ui.usuwanie.usuwaniePracownikaPoWieku(u, Integer.parseInt(rp.choice3));
                        break;
                    }

                    case 4: {
                        ui.usuwanie.usuwaniePracownikaPoStazu(u, Integer.parseInt(rp.choice3));
                        break;
                    }
                }
            }

            model.removeAllElements();
            for(Osoba o: u.Osoby){
                model.addElement(o);
            }
        }

        if(zdarzenie.getSource() == b6){
           FindPerson fp = new FindPerson(u);
        }

        if (zdarzenie.getSource() == b7) {
            model.removeAllElements();
            ui.dzialaniaNaPlikach.s.wczytanieOsob(u);
            for(Osoba o: u.Osoby){
                model.addElement(o);
            }
        }

        if (zdarzenie.getSource() == b8) {
            ui.dzialaniaNaPlikach.s.zapiszOsoby(u);
        }

        if(zdarzenie.getSource() == b9){
            ui.usuwanie.usuwanieDuplikatowOsob(u);
            model.removeAllElements();
            for(Osoba o: u.Osoby){
                model.addElement(o);
            }
        }
    }
}
