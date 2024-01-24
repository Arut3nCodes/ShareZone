package Wyszukiwanie;

import Kurs.Kurs;
import Osoba.Osoba;
import Uczelnia.Uczelnia;

import java.util.ArrayList;

public class WyszukiwanieKursy {

    public ArrayList<Kurs> wyszukajPoNazwieKursu(String nazwa, Uczelnia u) { // dla studentow
        ArrayList<Kurs> k1 = new ArrayList<>();
        int check = 0;
        for(Kurs k: u.Kursy){
            if(k instanceof Kurs){
                if(k.getNazwaKursu().equals(nazwa)){
                    k1.add(k);
                }
            }
        }

        return k1;
    }

    public ArrayList<Kurs> wyszukajPoImieniuProwadzacego(String imieProwadzacego, Uczelnia u) { // dla studentow
        ArrayList<Kurs> k1 = new ArrayList<>();
        int check = 0;
        for(Kurs k: u.Kursy){
            if(k instanceof Kurs){
                if(k.getNazwaKursu().equals(imieProwadzacego)){
                    k1.add(k);
                }
            }
        }

        return k1;
    }

    public ArrayList<Kurs> wyszukajPoNazwiskuProwadzacego(String nazwiskoProwadzacego, Uczelnia u) { // dla studentow
        ArrayList<Kurs> k1 = new ArrayList<>();
        int check = 0;
        for(Kurs k: u.Kursy){
            if(k instanceof Kurs){
                if(k.getNazwaKursu().equals(nazwiskoProwadzacego)){
                    k1.add(k);
                }
            }
        }

        return k1;
    }

    public ArrayList<Kurs> wyszukajPoPunktachECTS(int punktyECTS, Uczelnia u) { // dla studentow
        ArrayList<Kurs> k1 = new ArrayList<>();
        int check = 0;
        for(Kurs k: u.Kursy){
            if(k instanceof Kurs){
                if(k.getPunktyETC() == punktyECTS){
                    k1.add(k);
                }
            }
        }

        return k1;
    }
}
