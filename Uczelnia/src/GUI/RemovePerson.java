package GUI;

import Kurs.Kurs;
import Osoba.*;
import Uczelnia.Uczelnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class RemovePerson implements ActionListener {
    Uczelnia u;
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JComboBox<String> cb, cb1, cb2;
    int choice1;
    int choice2;
    String choice3;

    public RemovePerson(Uczelnia u){
        this.u = u;
        String[] Strings = {"...","Student", "Pracownik"};
        cb = new JComboBox<>(Strings);
        cb1 = new JComboBox<>();
        cb2 = new JComboBox<>();
        cb.addActionListener(this);
        cb1.addActionListener(this);
        cb2.addActionListener(this);

        cb1.addItem("...");
        cb2.addItem("...");

        cb.setPreferredSize(new Dimension(100, 25));
        cb.setMinimumSize(new Dimension(100, 50));
        cb.setMaximumSize(new Dimension(100, 50));

        cb1.setPreferredSize(new Dimension(100, 25));
        cb1.setMinimumSize(new Dimension(100, 50));
        cb1.setMaximumSize(new Dimension(100, 50));

        cb2.setPreferredSize(new Dimension(100, 25));
        cb2.setMinimumSize(new Dimension(100, 50));
        cb2.setMaximumSize(new Dimension(100, 50));

        p.add(new JLabel("Wybierz typ usuwanej osoby"));
        p.add(cb);
        p.add(new JLabel("Wybierz po czym usuwamy"));
        p.add(cb1);
        p.add(cb2);

        int result = JOptionPane.showConfirmDialog(null, p,
                "Sortowanie", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            choice1 = cb.getSelectedIndex();
            choice2 = cb1.getSelectedIndex();
            choice3 = (String)cb2.getSelectedItem();
        }

        else if(result == JOptionPane.OK_CANCEL_OPTION){
            choice1 = 0;
            choice2 = 0;
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
}
