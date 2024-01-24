package Osoba;
import Kurs.Kurs;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;

public class Student extends Osoba {
    private int nrIndeksu;
    boolean czyErasmus;
    boolean czyStudentStopnia;
    boolean czyStudentStacjonarny;

    public Student(){

    }

    public Student(String imie, String nazwisko, String pesel, int wiek, boolean plec, int nrIndeksu, boolean czyErasmus, boolean czyStudentStopnia, boolean czyStudentStacjonarny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wiek = wiek;
        this.plec = plec;
        this.nrIndeksu = nrIndeksu;
        this.czyErasmus = czyErasmus;
        this.czyStudentStopnia = czyStudentStopnia;
        this.czyStudentStacjonarny = czyStudentStacjonarny;
    }

    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public boolean isCzyErasmus() {
        return czyErasmus;
    }

    public void setCzyErasmus(boolean czyErasmus) {
        this.czyErasmus = czyErasmus;
    }

    public boolean isCzyStudentStopnia() {
        return czyStudentStopnia;
    }

    public void setCzyStudentStopnia(boolean czyStudentStopnia) {
        this.czyStudentStopnia = czyStudentStopnia;
    }

    public boolean isCzyStudentStacjonarny() {
        return czyStudentStacjonarny;
    }

    public void setCzyStudentStacjonarny(boolean czyStudentStacjonarny) {
        this.czyStudentStacjonarny = czyStudentStacjonarny;
    }

    public void getStan(){
        System.out.print("Imie: " + imie +
                "  Nazwisko: " + nazwisko +
                "  PESEL: " + pesel +
                "  Wiek: " + wiek +
                "  Plec: (t -> m || f -> k) " + plec +
                "  Numer Indeksu: " + nrIndeksu +
                "  Czy Erasmus: " + czyErasmus +
                "  Stopien: (t -> I || f -> II) " + czyStudentStopnia +
                "  Czy Stacjonarny: " + czyStudentStacjonarny +
                "  Kursy: [");
//                for(Kurs k: kursy){
//                    System.out.print(k.getNazwaKursu() + ", ");
//        }
//        System.out.println("] ");
    }

//    public void dolaczDoKursu(Kurs k){
//        kursy.add(k);
//    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " | "
                +  "Imie: " + imie +
                " | Nazwisko: " + nazwisko +
                " | PESEL: " + pesel +
                " | Wiek: " + wiek +
                " | Plec: (t -> m || f -> k) " + plec +
                " | Numer Indeksu: " + nrIndeksu +
                " | Czy Erasmus: " + czyErasmus +
                " | Stopien: (t -> I || f -> II) " + czyStudentStopnia +
                " | Czy Stacjonarny: " + czyStudentStacjonarny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getNrIndeksu() == student.getNrIndeksu();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPesel());
    }
}
