package Kurs;

import java.io.*;

public class Kurs implements Serializable{
    String nazwaKursu;
    String imieProwadzacego;
    String nazwiskoProwadzacego;
    int punktyETC;

    public Kurs(){

    }

    public Kurs(String nazwaKursu, String imieProwadzacego, String nazwiskoProwadzacego, int punktyETC) {
        this.nazwaKursu = nazwaKursu;
        this.imieProwadzacego = imieProwadzacego;
        this.nazwiskoProwadzacego = nazwiskoProwadzacego;
        this.punktyETC = punktyETC;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public String getImieProwadzacego() {
        return imieProwadzacego;
    }

    public void setImieProwadzacego(String imieProwadzacego) {
        this.imieProwadzacego = imieProwadzacego;
    }

    public String getNazwiskoProwadzacego() {
        return nazwiskoProwadzacego;
    }

    public void setNazwiskoProwadzacego(String nazwiskoProwadzacego) {
        this.nazwiskoProwadzacego = nazwiskoProwadzacego;
    }

    public int getPunktyETC() {
        return punktyETC;
    }

    public void setPunktyETC(int punktyETC) {
        this.punktyETC = punktyETC;
    }

    public void getStan(){
        System.out.println("Nazwa Kursu: " + nazwaKursu +
                " | Imie i nazwisko prowadzacego: " + imieProwadzacego + " " + nazwiskoProwadzacego +
                " | Ilosc punktow ETC: " + punktyETC);
    }
//@Override
  public String toString(){
       return(  "Nazwa Kursu: " + nazwaKursu +
                " | Imie i nazwisko prowadzacego: " + imieProwadzacego + " " + nazwiskoProwadzacego +
                " | Ilosc punktow ETC: " + punktyETC);

  }
}
