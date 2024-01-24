package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Kurs.*;
import UI.WczytanieZPliku.Serializacja;
import Uczelnia.*;
import UI.*;

public class ListaKursow extends JSplitPane implements ActionListener {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;

    DefaultListModel<Kurs> model = new DefaultListModel<>();
    JList<Kurs> list;
    Uczelnia u;
    UI ui;

    public ListaKursow(Uczelnia u) {
        super();
        this.u = u;
        this.ui = new UI();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.setBackground(Color.darkGray);
        this.setDividerLocation(670);

        list = new JList<>(model);
        b1 = new JButton("Dodaj Kurs");
        b2 = new JButton("Sortuj");
        b3 = new JButton("Usun");
        b4 = new JButton("Wyszukaj");
        b5 = new JButton("Wczytaj Kursy z pliku");
        b6 = new JButton("Zapisz Kursy do pliku");

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




        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);

        list.setBackground(Color.lightGray);

        this.setBackground(Color.lightGray);
        this.setLeftComponent(new JScrollPane(list));
        this.setRightComponent(panel);


    }

    public void actionPerformed(ActionEvent zdarzenie) {
        if (zdarzenie.getSource() == b1) {
            DodajKurs k = new DodajKurs();
            model.addElement(k.k);
            u.dodajKurs(k.k);
        }

        if(zdarzenie.getSource() == b2){
            ui.sortowanie.sortowaniePoECTSINazwiskuProwadzacego(u);
            model.removeAllElements();
            for(Kurs k: u.Kursy){
                model.addElement(k);
            }
        }

        if(zdarzenie.getSource() == b3){
            RemoveCourse rc = new RemoveCourse(u);
            switch(rc.choice1){
                case 1: {
                    ui.usuwanie.usuwanieKursuPoNazwie(u, rc.choice2);
                    model.removeAllElements();
                    for(Kurs k: u.Kursy){
                        model.addElement(k);
                    }
                    System.out.println(1);
                    break;
                }

                case 2: {
                    ui.usuwanie.usuwanieKursuPoNazwiskuProwadzacego(u, rc.choice2);
                    model.removeAllElements();
                    for(Kurs k: u.Kursy){
                        model.addElement(k);
                    }
                    System.out.println(2);
                    break;
                }

                case 3: {
                    ui.usuwanie.usuwanieKursuPoPunktachECTS(u, Integer.parseInt(rc.choice2));
                    model.removeAllElements();
                    for(Kurs k: u.Kursy){
                        model.addElement(k);
                    }
                    System.out.println(3);
                    break;
                }

                default: break;
            }

        }

        if(zdarzenie.getSource() == b4){
            FindCourse fc = new FindCourse(u);
        }

        if (zdarzenie.getSource() == b5) {
            model.removeAllElements();
            ui.dzialaniaNaPlikach.s.wczytanieKursow(u);
            for(Kurs k: u.Kursy){
                model.addElement(k);
            }
        }

        if (zdarzenie.getSource() == b6) {
                ui.dzialaniaNaPlikach.s.zapiszKursy(u);
        }
    }
}


