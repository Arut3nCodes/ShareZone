package GUI;

import Osoba.PracownikAdm;

import javax.swing.*;

public class DodajPracownikaAdm {
    JPanel p = new JPanel();
    PracownikAdm pa;

    public DodajPracownikaAdm(){
        JTextField imie = new JTextField(5);
        JTextField nazwisko = new JTextField(5);
        JTextField pesel = new JTextField(5);
        JTextField wiek = new JTextField(5);
        JTextField plec = new JTextField(5);
        JTextField stanowisko = new JTextField(5);
        JTextField stazPracy = new JTextField(5);
        JTextField pensja = new JTextField(5);
        JTextField liczbaNadgodzin = new JTextField(5);

        p.add(new JLabel("Imie"));
        p.add(imie);
        p.add(new JLabel("Nazwisko"));
        p.add(nazwisko);
        p.add(new JLabel("Pesel"));
        p.add(pesel);
        p.add(new JLabel("Wiek"));
        p.add(wiek);
        p.add(new JLabel("Plec"));
        p.add(plec);
        p.add(new JLabel("stanowisko"));
        p.add(stanowisko);
        p.add(new JLabel("staz pracy"));
        p.add(stazPracy);
        p.add(new JLabel("pensja"));
        p.add(pensja);
        p.add(new JLabel("liczba nadgodzin"));
        p.add(liczbaNadgodzin);

        int result = JOptionPane.showConfirmDialog(null, p,
                "Wpisz dane studenta", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            pa = new PracownikAdm(imie.getText(), nazwisko.getText(), pesel.getText(), Integer.parseInt(wiek.getText()), Boolean.parseBoolean(plec.getText()), stanowisko.getText(), Integer.parseInt(stazPracy.getText()), Integer.parseInt(pensja.getText()), Integer.parseInt(liczbaNadgodzin.getText()));
        }
    }
}
