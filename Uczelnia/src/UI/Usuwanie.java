package UI;

import Uczelnia.*;
import Osoba.*;
import Kurs.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Usuwanie {
    public Usuwanie() {

    }

    public void usuwaniePoImieniu(Uczelnia u) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podac imie do usuniecia");
        String imie = scan.next();
        System.out.println("Usunac: ");
        System.out.println("1. Studenta");
        System.out.println("2. Pracownika");
        int choice = 0;
        choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Blad, prose ponownie podac numer");
            choice = scan.nextInt();
        }
        int check = 0;
        switch (choice) {
            case 1: {
                for (int i = 0; i < u.Osoby.size(); i++) {
                    if (u.Osoby.get(i) instanceof Student) {
                        if (u.Osoby.get(i).getImie().equals(imie)) {
                            u.Osoby.remove(u.Osoby.get(i));
                            check++;
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < u.Osoby.size(); i++) {
                    if (u.Osoby.get(i) instanceof PracownikUczelni) {
                        if (u.Osoby.get(i).getImie().equals(imie)) {
                            u.Osoby.remove(u.Osoby.get(i));
                            check++;
                        }
                    }
                }
                break;
            }
            default: {
                System.out.println("Cos nie dziala");
                break;
            }
        }

        System.out.println("Usunieto " + check + " osob");

    }

    public void usuwanieStudentaPoImieniu(Uczelnia u, String imie) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof Student) {
                if (u.Osoby.get(i).getImie().equals(imie)) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }

    public void usuwanieStudentaPoNrIndeksu(Uczelnia u, int indeks) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof Student) {
                if (((Student) u.Osoby.get(i)).getNrIndeksu() == indeks) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }

    public void usuwaniePracownikaPoImieniu(Uczelnia u, String imie) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof Student) {
                if (u.Osoby.get(i).getImie().equals(imie)) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }


    public void usuwaniePoNazwisku(Uczelnia u) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podac nazwisko do usuniecia");
        String nazwisko = scan.next();
        System.out.println("Usunac: ");
        System.out.println("1. Studenta");
        System.out.println("2. Pracownika");
        int choice = 0;
        choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Blad, prose ponownie podac numer");
            choice = scan.nextInt();
        }
        int check = 0;
        switch (choice) {
            case 1: {
                for (int i = 0; i < u.Osoby.size(); i++) {
                    if (u.Osoby.get(i) instanceof Student) {
                        if (u.Osoby.get(i).getNazwisko().equals(nazwisko)) {
                            u.Osoby.remove(u.Osoby.get(i));
                            check++;
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < u.Osoby.size(); i++) {
                    if (u.Osoby.get(i) instanceof PracownikUczelni) {
                        if (u.Osoby.get(i).getNazwisko().equals(nazwisko)) {
                            u.Osoby.remove(u.Osoby.get(i));
                            check++;
                        }
                    }
                }
                break;
            }
            default: {
                System.out.println("Cos nie dziala");
                break;
            }
        }

        System.out.println("Usunieto " + check + " osob");

    }

    public void usuwanieStudentaPoNazwisku(Uczelnia u, String nazwisko) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof Student) {
                if (u.Osoby.get(i).getNazwisko().equals(nazwisko)) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }

    public void usuwaniePracownikaPoNazwisku(Uczelnia u, String nazwisko) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof PracownikUczelni) {
                if (u.Osoby.get(i).getNazwisko().equals(nazwisko)) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }

    public void usuwaniePoWieku(Uczelnia u) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podac wiek do usuniecia");
        int wiek = scan.nextInt();
        System.out.println("Usunac: ");
        System.out.println("1. Studenta");
        System.out.println("2. Pracownika");
        int choice = 0;
        choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Blad, prose ponownie podac numer");
            choice = scan.nextInt();
        }
        int check = 0;
        switch (choice) {
            case 1: {
                for (int i = u.Osoby.size() - 1; i >= 0; i--) {
                    if (u.Osoby.get(i) instanceof Student) {
                        if (u.Osoby.get(i).getWiek() == wiek) {
                            u.Osoby.remove(u.Osoby.get(i));
                            check++;
                        }
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < u.Osoby.size(); i++) {
                    if (u.Osoby.get(i) instanceof PracownikUczelni) {
                        if (u.Osoby.get(i).getWiek() == wiek) {
                            u.Osoby.remove(u.Osoby.get(i));
                            check++;
                        }
                    }
                }
                break;
            }
            default: {
                System.out.println("Cos nie dziala");
                break;
            }
        }

        System.out.println("Usunieto " + check + " osob");

    }

    public void usuwanieStudentaPoWieku(Uczelnia u, int wiek) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof Student) {
                if (u.Osoby.get(i).getWiek() == wiek) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }

    public void usuwaniePracownikaPoWieku(Uczelnia u, int wiek) {
        for (int i = u.Osoby.size() - 1; i >= 0; i--) {
            if (u.Osoby.get(i) instanceof PracownikUczelni) {
                if (u.Osoby.get(i).getWiek() == wiek) {
                    u.Osoby.remove(u.Osoby.get(i));
                }
            }
        }
    }

    public void usuwaniePracownikaPoStazuScanner(Uczelnia u) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj staz: ");
        int staz = scan.nextInt();
        int check = 0;

        Iterator it = u.Osoby.iterator();
        while (it.hasNext()) {
            if (it instanceof PracownikUczelni) {
                if (((PracownikUczelni) it).getStazPracy() == staz) {
                    u.Osoby.remove(it);
                    check++;
                }
            }
        }
        System.out.println("Usunieto " + check + " osob");
    }

    public void usuwaniePracownikaPoStazu(Uczelnia u, int staz) {
        Iterator it = u.Osoby.iterator();
        while (it.hasNext()) {
            if (it instanceof PracownikUczelni) {
                if (((PracownikUczelni) it).getStazPracy() == staz) {
                    u.Osoby.remove(it);
                }
            }
        }
    }

    public void usuwanieKursuPoNazwie(Uczelnia u, String nazwa) {
        for (int i = u.Kursy.size() - 1; i >= 0; i--) {
            if (u.Kursy.get(i).getNazwaKursu().equals(nazwa)) {
                u.Kursy.remove(u.Kursy.get(i));
            }
        }
    }

    public void usuwanieKursuPoNazwiskuProwadzacego(Uczelnia u, String nazwisko) {
        for (int i = u.Kursy.size() - 1; i >= 0; i--) {
            if (u.Kursy.get(i).getNazwiskoProwadzacego().equals(nazwisko)) {
                u.Kursy.remove(u.Kursy.get(i));
            }
        }
    }

    public void usuwanieKursuPoPunktachECTS(Uczelnia u, int punkty) {
        for (int i = u.Kursy.size() - 1; i >= 0; i--) {
            if (u.Kursy.get(i).getPunktyETC() == punkty) {
                u.Kursy.remove(u.Kursy.get(i));
            }
        }
    }

    public void usuwanieDuplikatowOsob(Uczelnia u) {
        HashSet<Osoba> hs = new HashSet<>();

        for (Osoba o : u.Osoby) {
            hs.add(o);
            System.out.println(o.hashCode());
        }

        u.Osoby.clear();

        for (Osoba o : hs) {
            u.dodajOsobe(o);
        }

    }
}
