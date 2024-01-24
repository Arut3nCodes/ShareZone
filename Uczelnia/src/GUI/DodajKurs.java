package GUI;

import Kurs.Kurs;

import javax.swing.*;

public class DodajKurs {
    JPanel p = new JPanel();
    Kurs k;

    public DodajKurs(){
        JTextField nazwaKursu = new JTextField(5);
        JTextField imieProwadzacego = new JTextField(5);
        JTextField nazwiskoProwadzacego = new JTextField(5);
        JTextField punktyETC = new JTextField(5);

        p.add(new JLabel("Nazwa Kursu"));
        p.add(nazwaKursu);
        p.add(new JLabel("Imie Prowadzacego"));
        p.add(imieProwadzacego);
        p.add(new JLabel("Nazwisko Prowadzacego"));
        p.add(nazwiskoProwadzacego);
        p.add(new JLabel("Punkty ETC"));
        p.add(punktyETC);

        int result = JOptionPane.showConfirmDialog(null, p,
                "Wpisz dane studenta", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            k = new Kurs(nazwaKursu.getText(), imieProwadzacego.getText(), nazwiskoProwadzacego.getText(), Integer.parseInt(punktyETC.getText()));
        }
    }
}
