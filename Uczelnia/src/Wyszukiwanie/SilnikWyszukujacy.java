package Wyszukiwanie;
import Osoba.*;
import Kurs.*;
import Uczelnia.Uczelnia;

/*
    Rozbudować projekt o 3 klasy dziedziczne dla poszczególnych obiektów
    Zamienić ten obiekt w interfejs bądź klasę abstrakcyjną
*/
public class SilnikWyszukujacy {
    protected Uczelnia uczelnia;

    SilnikWyszukujacy(Uczelnia u) {
        uczelnia = u;
    }



    public void wyszukajPoNazwisku(String nazwisko) { // dla studentow
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("#Lista wszystkich pracownikow o nazwisku " + nazwisko + "#");
        int check = 0;
        for(Osoba p: uczelnia.Osoby){
            if(p instanceof PracownikUczelni){
                if(p.getNazwisko().equals(nazwisko)){
                    p.getStan();
                    check++;
                }
            }
        }
        if(check == 0){
            System.out.println("Nie znaleziono nikogo o takim nazwisku");
        }
    }

    public void wyszukajPoETC(int ETC) { // dla kursow
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("#Lista wszystkich kursow o ilosci punktow ETC " + ETC + "#");
        int check = 0;
        for(Kurs k: uczelnia.Kursy){
            if(k.getPunktyETC() == ETC){
                k.getStan();
                check++;
            }
        }
        if(check == 0){
            System.out.println("Nie znaleziono takiego kursu");
        }
    }
}
