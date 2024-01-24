package Uczelnia;
import Kurs.*;
import Osoba.*;
import Wyszukiwanie.*;
import UI.*;

import java.lang.*;

public class Main {
    public static void main(String[] args){
        Student s1 = new Student("Jacek", "Gacek", "34556432123", 34, true, 234445, false, false, false);
        Student s2 = new Student("Tomasz", "Saul", "23456436378", 23, true, 234555, false, true, false);
        Student s3 = new Student("Jakub", "Susz", "02240502995", 19, true, 266555, false, false, true);
        Student s7 = new Student("Jakub", "Kononowski", "02240502995", 19, true, 266555, false, false, true);
        Student s4 = new Student("Anna", "Graul", "74567788954", 21, false, 234445, false, false, false);
        Student s5 = new Student("Joanna", "Grom", "234509866898", 21, false, 234555, false, true, false);
        Student s6 = new Student("Jakub", "Koneser", "32165498701", 23, true, 266555, false, false, true);

        PracownikAdm p1 = new PracownikAdm("Gracjan", "Chowanski", "12345678901", 45, true, "Konserwator", 14, 5000, 23);
        PracownikBadDyd p2 = new PracownikBadDyd("Slawomir", "Susz", "24466356785", 48, true, "Doktor", 15, 7600, 34);

        Kurs k1 = new Kurs("test1", "test", "jeden", 6);
        Kurs k2 = new Kurs("test2", "test", "dwa", 6);

        Uczelnia u1 = new Uczelnia("Politechnika Wroclawska");

        UI ui = new UI();

//        s1.dolaczDoKursu(k1);
//        s1.dolaczDoKursu(k2);
        u1.dodajOsobe(s1);
        u1.dodajOsobe(s2);
        u1.dodajOsobe(s3);
        u1.dodajOsobe(s4);
        u1.dodajOsobe(s5);
        u1.dodajOsobe(s6);
        u1.dodajOsobe(s7);
        u1.dodajOsobe(p1);
        u1.dodajOsobe(p2);
        u1.dodajOsobe(s3);
        u1.dodajKurs(k1);
        u1.dodajKurs(k2);


        //2 i 3

//         w1.wyszukajPoImieniu("Jakub");
//        w1.wyszukajPoImieniu("Tymoteusz");
//        w1.wyszukajPoNazwisku("Susz");
//        w1.wyszukajPoNazwisku("Komar");
//        w1.wyszukajPoETC(6);
//        w1.wyszukajPoETC(3);

       // etap_1
        //ui.modyfikator.dopiszPracownikaAdm(u1);
//        ui.modyfikator.dopiszKurs(u1);
//        ui.modyfikator.dopiszPracownikaBadDyd(u1);
//        ui.modyfikator.dopiszPracownikaAdm(u1);

        // etap_2
//        ui.dzialaniaNaPlikach.s.wczytanieOsob(u1);
//        ui.dzialaniaNaPlikach.s.wczytanieKursow(u1);
//       ui.dzialaniaNaPlikach.s.zapiszKursy(u1);
//       ui.dzialaniaNaPlikach.s.zapiszOsoby(u1);

        // etap_3
//        u1.wypiszWszystkichStudentow();
//        ui.sortowanie.sortowaniePoNazwisku(u1);
//        u1.wypiszWszystkichStudentow();
        //ui.sortowanie.sortowaniePoECTSIProwadzacym(u1);
//       ui.sortowanie.sortowaniePoNazwiskuIWieku(u1);
//        ui.sortowanie.sortowaniePoNazwiskuIImieniu(u1);

        // etap_4
        u1.wypiszWszystkichStudentow();
        ui.usuwanie.usuwanieDuplikatowOsob(u1);
        u1.wypiszWszystkichStudentow();
//        ui.usuwanie.usuwaniePoNazwisku(u1);
//        ui.usuwanie.usuwaniePoWieku(u1);
        //ui.usuwanie.usuwaniePracownikaPoStazu(u1);
//        ui.usuwanie.usuwanieKursuPoNazwie(u1);
//        ui.usuwanie.usuwanieKursuPoNazwiskuProwadzacego(u1);
//        ui.usuwanie.usuwanieKursuPoPunktachECTS(u1);



    }
}
