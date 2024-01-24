package UI;

import Uczelnia.*;
import Osoba.*;
import Kurs.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Modyfikator {
    Uczelnia uczelnia;

    public Modyfikator() {
    }

    public void dopiszStudenta(Uczelnia uczelnia) { // bez kursow
        Scanner scan = new Scanner(System.in);
        Student s = new Student();
        /*
        PracownikUczelni p;

        System.out.println("Dodac: ");
        System.out.println("1. Pracownika Administracyjnego");
        System.out.println("2. Pracownika Badawczo-Dydaktycznego");
        int choice = 0;
        choice = scan.nextInt();
        while (choice != 1 || choice != 2) {
            System.out.println("Blad, prose ponownie podac numer");
            choice = scan.nextInt();
        }

        switch (choice) {
            case 1: {
                p = new PracownikAdm();
                break;
            }
            case 2: {
                p = new PracownikBadDyd();
                break;
            }
            default: {
                System.out.println("Cos nie dziala");
                break;
            }
        } */

        System.out.println("Podaj imie studenta");
        s.setImie(scan.next());
        System.out.println("Podaj nazwisko studenta");
        s.setNazwisko(scan.next());
        System.out.println("Podaj PESEL studenta");
        s.setPesel(scan.next());
        System.out.println("Podaj wiek studenta");
        s.setWiek(scan.nextInt());
        System.out.println("Podaj plec studenta");
        s.setPlec(scan.nextBoolean());
        System.out.println("Podaj numer indeksu studenta");
        s.setNrIndeksu(scan.nextInt());
        System.out.println("Podaj czy student uczestniczy w erasmusie");
        s.setCzyErasmus(scan.nextBoolean());
        System.out.println("Podaj czy student uczestniczy w Rajesh stacjonarnych");
        s.setCzyStudentStacjonarny(scan.nextBoolean());
        System.out.println("Podaj czy student studiuje na I stopniu");
        s.setCzyStudentStopnia(scan.nextBoolean());

      /*  if (p instanceof PracownikAdm) {
            System.out.println("Podaj liczbe nadgodzin pracownika");
            p.setPensja(scan.nextInt());
        } else if (p instanceof PracownikBadDyd) {
            System.out.println("Podaj dorobek naukowy pracownika");
            p.setDorobekNaukowy(scan.nextInt());
        } */
        uczelnia.dodajOsobe(s);


    }

    public void dopiszPracownikaAdm(Uczelnia uczelnia) {
        Scanner scan = new Scanner(System.in);
        PracownikAdm p = new PracownikAdm();
        /*
        PracownikUczelni p;

        System.out.println("Dodac: ");
        System.out.println("1. Pracownika Administracyjnego");
        System.out.println("2. Pracownika Badawczo-Dydaktycznego");
        int choice = 0;
        choice = scan.nextInt();
        while (choice != 1 || choice != 2) {
            System.out.println("Blad, prose ponownie podac numer");
            choice = scan.nextInt();
        }

        switch (choice) {
            case 1: {
                p = new PracownikAdm();
                break;
            }
            case 2: {
                p = new PracownikBadDyd();
                break;
            }
            default: {
                System.out.println("Cos nie dziala");
                break;
            }
        } */

        System.out.println("Podaj imie pracownika");
        p.setImie(scan.next());
        System.out.println("Podaj nazwisko pracownika");
        p.setNazwisko(scan.next());
        System.out.println("Podaj PESEL pracownika");
        p.setPesel(scan.next());
        System.out.println("Podaj wiek pracownika");
        p.setWiek(scan.nextInt());
        System.out.println("Podaj plec pracownika");
        p.setPlec(scan.nextBoolean());
        System.out.println("Podaj stanowisko pracownika");
        p.setStanowisko(scan.next());
        System.out.println("Podaj staz pracy pracownika");
        p.setStazPracy(scan.nextInt());
        System.out.println("Podaj pensje pracownika");
        p.setPensja(scan.nextInt());
        System.out.println("Podaj liczbe nadgodzin pracownika");
        p.setLiczbaNadgodzin(scan.nextInt());

      /*  if (p instanceof PracownikAdm) {
            System.out.println("Podaj liczbe nadgodzin pracownika");
            p.setPensja(scan.nextInt());
        } else if (p instanceof PracownikBadDyd) {
            System.out.println("Podaj dorobek naukowy pracownika");
            p.setDorobekNaukowy(scan.nextInt());
        } */
        uczelnia.dodajOsobe(p);


    }

    public void dopiszPracownikaBadDyd(Uczelnia u){
        Scanner scan = new Scanner(System.in);
        PracownikBadDyd p = new PracownikBadDyd();
        System.out.println("Podaj imie pracownika");
        p.setImie(scan.next());
        System.out.println("Podaj nazwisko pracownika");
        p.setNazwisko(scan.next());
        System.out.println("Podaj PESEL pracownika");
        p.setPesel(scan.next());
        System.out.println("Podaj wiek pracownika");
        p.setWiek(scan.nextInt());
        System.out.println("Podaj plec pracownika");
        p.setPlec(scan.nextBoolean());
        System.out.println("Podaj stanowisko pracownika");
        p.setStanowisko(scan.nextLine());
        System.out.println("Podaj staz pracy pracownika");
        p.setStazPracy(scan.nextInt());
        System.out.println("Podaj pensje pracownika");
        p.setPensja(scan.nextInt());
        System.out.println("Podaj dorobek naukowy pracownika");
        p.setDorobekNaukowy(scan.nextInt());

        uczelnia.dodajOsobe(p);

    }

    public void dopiszKurs(Uczelnia uczelnia) {
        Scanner scan = new Scanner(System.in);
        Kurs k = new Kurs();
        System.out.println("Podaj nazwe przedmiotu: ");
        k.setNazwaKursu(scan.next());
        System.out.println("Podaj imie prowadzacego: ");
        k.setImieProwadzacego(scan.next());
        System.out.println("Podaj imie prowadzacego: ");
        k.setNazwiskoProwadzacego(scan.next());
        System.out.println("Podaj punkty ECT: ");
        k.setPunktyETC(scan.nextInt());

        uczelnia.dodajKurs(k);
     }


    /* public void dopiszCos(){
        switch
    } */
}
