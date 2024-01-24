package Osoba;

import java.util.Objects;

public abstract class PracownikUczelni extends Osoba{
    protected String stanowisko;
    protected int stazPracy;
    protected int pensja;

    public PracownikUczelni(){

    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public void setStazPracy(int stazPracy) {
        this.stazPracy = stazPracy;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        PracownikUczelni pracownik = (PracownikUczelni) o;
        return getPesel().equals(pracownik.getPesel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPesel());
    }
}
