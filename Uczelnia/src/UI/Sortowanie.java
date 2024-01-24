package UI;

import Osoba.*;
import Kurs.*;
import Uczelnia.*;

import java.util.Collections;
import java.util.Comparator;

public class    Sortowanie {
    public void sortowaniePoNazwisku(Uczelnia u){
        Collections.sort(u.Osoby, new PoNazwiskach());
    }
    public void sortowaniePoNazwiskuIImieniu(Uczelnia u){
        Collections.sort(u.Osoby, new PoNazwiskachIImionach());
    }
    public void sortowaniePoNazwiskuIWieku(Uczelnia u){
        Collections.sort(u.Osoby, new PoNazwiskachIWieku());
    }
    public void sortowaniePoECTSINazwiskuProwadzacego(Uczelnia u){
        Collections.sort(u.Kursy, new PoECTSINazwisku());
    }
}


class PoNazwiskach implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2)
    {
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}

class PoNazwiskachIImionach implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2)
    {
        if(o1.getNazwisko().compareTo(o2.getNazwisko()) == 0){
            return o1.getImie().compareTo(o2.getImie());
        }
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}

class PoNazwiskachIWieku implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2)
    {
        if(o1.getNazwisko().compareTo(o2.getNazwisko()) == 0){
            if (o1.getWiek() > o2.getWiek()) return 0;
            else if (o1.getWiek() == o2.getWiek()) return 1;
            else  return -1;
        }
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}

class PoECTSINazwisku implements Comparator<Kurs> {
    @Override
    public int compare(Kurs k1, Kurs k2)
    {
        if (k1.getPunktyETC() == k2.getPunktyETC())
            return k1.getNazwiskoProwadzacego().compareTo(k2.getNazwiskoProwadzacego());
        else if (k1.getPunktyETC() > k2.getPunktyETC()) return 1;
        else return -1;

    }
}
