package Uczelnia;

import java.util.ArrayList;
import Osoba.*;
import Kurs.*;

public class Uczelnia {
    private String nazwaUczelni;
    public ArrayList<Osoba> Osoby;
    public ArrayList<Kurs> Kursy;

    public Uczelnia(String nazwaUczelni){
        this.nazwaUczelni = nazwaUczelni;
        this.Osoby = new ArrayList<Osoba>();
        this.Kursy = new ArrayList<Kurs>();
    }

    public String getString(){
        return nazwaUczelni;
    }

    public void setString(String nazwaUczelni){
        this.nazwaUczelni = nazwaUczelni;
    }

    public void wypiszWszystkichStudentow(){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("#Lista wszystkich studentow#");
        for(Osoba a: Osoby){
            if(a instanceof Student){
                a.getStan();
            }
        }
    }

    public void wypiszWszystkichPracownikow(){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("#Lista wszystkich pracownikow#");
        for(Osoba p: Osoby){
            if(p instanceof PracownikUczelni){
                p.getStan();
            }
        }
    }

    public void wypiszWszystkieKursy(){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("#Lista wszystkich studentow#");
        for(Kurs k: Kursy){
            k.getStan();
        }
    }

    public void dodajOsobe(Osoba p){
        Osoby.add(p);
    }

    public void dodajKurs(Kurs k){
        Kursy.add(k);
    }



}
