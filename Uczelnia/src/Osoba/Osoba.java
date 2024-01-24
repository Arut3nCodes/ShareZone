package Osoba;

import java.io.*;
import java.util.Objects;

public abstract class Osoba implements OsobaStrategia, Serializable{
    protected String imie;
    protected String nazwisko;
    protected String pesel;
    protected int wiek;
    protected boolean plec;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public boolean isPlec() {
        return plec;
    }

    public void setPlec(boolean plec) {
        this.plec = plec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPesel());
    }

}
