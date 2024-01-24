package Wyszukiwanie;

import Kurs.Kurs;
import Osoba.*;
import Uczelnia.*;

import java.util.ArrayList;

public class WyszukiwanieStudenci{

    public ArrayList<Osoba> wyszukajPoImieniuStudenta(String imie, Uczelnia u) { // dla studentow
        ArrayList<Osoba> s1 = new ArrayList<>();
        int check = 0;
        for(Osoba s: u.Osoby){
            if(s instanceof Student){
                if(s.getImie().equals(imie)){
                    s1.add(s);
                }
            }
        }

        return s1;
    }


    public ArrayList<Osoba> wyszukajPoNazwiskuStudenta(String nazwisko, Uczelnia u) { // dla studentow
        ArrayList<Osoba> s1 = new ArrayList<>();
        int check = 0;
        for(Osoba s: u.Osoby){
            if(s instanceof Student){
                if(s.getNazwisko().equals(nazwisko)){
                    s1.add(s);
                }
            }
        }

        return s1;
    }

    public ArrayList<Osoba> wyszukajPoWiekuStudenta(int wiek, Uczelnia u) { // dla studentow
        ArrayList<Osoba> s1 = new ArrayList<>();
        int check = 0;
        for(Osoba s: u.Osoby){
            if(s instanceof Student){
                if(s.getWiek() == wiek){
                    s1.add(s);
                }
            }
        }

        return s1;
    }

    public ArrayList<Osoba> wyszukajPoNrIndeksu(int nrIndeksu, Uczelnia u) { // dla studentow
        ArrayList<Osoba> s1 = new ArrayList<>();
        int check = 0;
        for(Osoba s: u.Osoby){
            if(s instanceof Student){
                if(((Student) s).getNrIndeksu() == nrIndeksu){
                    s1.add(s);
                }
            }
        }

        return s1;
    }
}
