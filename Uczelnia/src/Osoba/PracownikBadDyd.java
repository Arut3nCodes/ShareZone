package Osoba;

public class PracownikBadDyd extends PracownikUczelni {  // Pracownik Badawczo-dydaktyczny
    private int dorobekNaukowy;

    public PracownikBadDyd(){

    }

    public PracownikBadDyd(String imie, String nazwisko, String pesel, int wiek, boolean plec, String stanowisko, int stazPracy, int pensja, int dorobekNaukowy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        this.pensja = pensja;
        this.dorobekNaukowy = dorobekNaukowy;
    }

    public int getDorobekNaukowy() {
        return dorobekNaukowy;
    }

    public void setDorobekNaukowy(int dorobekNaukowy) {
        this.dorobekNaukowy = dorobekNaukowy;
    }

    public void getStan(){
        System.out.println("Imie: " + imie +
                "  Nazwisko: " + nazwisko +
                "  PESEL: " + pesel +
                "  Wiek: " + wiek +
                "  Plec: " + plec +
                "  Stanowisko: " + stanowisko +
                "  Staz pracy: " + stazPracy +
                "  Pensja: " + pensja +
                "  Punkty dorobku naukowego: " + dorobekNaukowy);
    }

    @Override
    public String toString(){
        return (this.getClass().getSimpleName() + " | " + "Imie: " + imie +
                " | Nazwisko: " + nazwisko +
                " | PESEL: " + pesel +
                " | Wiek: " + wiek +
                " | Plec: " + plec +
                " | Stanowisko: " + stanowisko +
                " | Staz pracy: " + stazPracy +
                " | Pensja: " + pensja +
                " | Punkty dorobku naukowego: " + dorobekNaukowy);
    }


}
