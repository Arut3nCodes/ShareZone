package UI;

public class UI {
    public Modyfikator modyfikator;
    public Sortowanie sortowanie;
    public WczytanieZPliku dzialaniaNaPlikach;
    public Usuwanie usuwanie;

    public UI(){
        this.modyfikator = new Modyfikator();
        this.sortowanie = new Sortowanie();
        this.dzialaniaNaPlikach = new WczytanieZPliku();
        this.usuwanie = new Usuwanie();
    }
}
