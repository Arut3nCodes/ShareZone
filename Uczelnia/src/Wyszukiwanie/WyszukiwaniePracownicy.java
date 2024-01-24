package Wyszukiwanie;

import Osoba.*;
import Uczelnia.Uczelnia;

import java.util.ArrayList;

public class WyszukiwaniePracownicy {

    public ArrayList<Osoba> wyszukajPoImieniuPracownika(String imie, Uczelnia u) { // dla studentow
        ArrayList<Osoba> p1 = new ArrayList<>();
        for(Osoba p: u.Osoby){
            if(p instanceof PracownikUczelni){
                if(p.getImie().equals(imie)){
                    p1.add(p);
                }
            }
        }

        return p1;
    }


    public ArrayList<Osoba> wyszukajPoNazwiskuPracownika(String nazwisko, Uczelnia u) { // dla studentow
        ArrayList<Osoba> p1 = new ArrayList<>();
        for(Osoba p: u.Osoby){
            if(p instanceof PracownikUczelni){
                if(p.getNazwisko().equals(nazwisko)){
                    p1.add(p);
                }
            }
        }

        return p1;
    }

    public ArrayList<Osoba> wyszukajPoWiekuPracownika(int wiek, Uczelnia u) { // dla studentow
        ArrayList<Osoba> p1 = new ArrayList<>();
        for (Osoba p : u.Osoby) {
            if (p instanceof PracownikUczelni) {
                if (((PracownikUczelni) p).getWiek() == wiek) {
                    p1.add(p);
                }
            }
        }

        return p1;
    }
    public ArrayList<Osoba> wyszukajPoStazuPracownika(int stazPracy, Uczelnia u) { // dla studentow
        ArrayList<Osoba> p1 = new ArrayList<>();
        for (Osoba p : u.Osoby) {
            if (p instanceof PracownikUczelni) {
                if (((PracownikUczelni) p).getStazPracy() == stazPracy) {
                    p1.add(p);
                }
            }
        }

        return p1;
    }
}
