package Osoba;

public class PracownikAdm extends PracownikUczelni{
    int liczbaNadgodzin;

    public PracownikAdm(){

    }

    public PracownikAdm(String imie, String nazwisko, String pesel, int wiek, boolean plec, String stanowisko, int stazPracy, int pensja, int liczbaNadgodzin) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        this.pensja = pensja;
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public int getLiczbaNadgodzin(){
        return this.liczbaNadgodzin;
    }

    public void setLiczbaNadgodzin(int nadgodziny){
        this.liczbaNadgodzin = nadgodziny;
    }

    public void getStan(){
        System.out.println("Imie: " + imie +
                " Nazwisko: " + nazwisko +
                " PESEL: " + pesel +
                " Wiek: " + wiek +
                " Plec: " + plec +
                " Stanowisko: " + stanowisko +
                " Staz pracy: " + stazPracy +
                " Pensja: " + pensja +
                " Liczba nadgodzin: " + liczbaNadgodzin);
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " | " + "Imie: " + imie +
                " | Nazwisko: " + nazwisko +
                " | PESEL: " + pesel +
                " | Wiek: " + wiek +
                " | Plec: " + plec +
                " | Stanowisko: " + stanowisko +
                " | Staz pracy: " + stazPracy +
                " | Pensja: " + pensja +
                " | Liczba nadgodzin: " + liczbaNadgodzin;
    }
}
