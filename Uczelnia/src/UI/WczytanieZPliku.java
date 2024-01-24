package UI;

import java.io.*;
import java.util.ArrayList;
import Kurs.*;
import Uczelnia.*;
import Osoba.*;

public class WczytanieZPliku {

    public Serializacja s;

    WczytanieZPliku(){
        this.s = new Serializacja();
    }
    public class Serializacja {

        public void zapiszKursy(Uczelnia u) {
            try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Kursy.ser"))) {
                so.writeObject(u.Kursy);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void wczytanieKursow(Uczelnia u) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Kursy.ser"))) {
                Object obj1 = is.readObject();
                is.close();
                u.Kursy = (ArrayList<Kurs>) obj1;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                u.Kursy = null;
            }

        }

        public void zapiszOsoby(Uczelnia u) {
            try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Osoby.ser"))) {
                so.writeObject(u.Osoby);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void wczytanieOsob(Uczelnia u) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Osoby.ser"))) {
                Object obj1 = is.readObject();
                is.close();
                u.Osoby = (ArrayList<Osoba>) obj1;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                u.Osoby = null;
            }

        }
    }
}
