package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Uczelnia.*;

public class App {
    Uczelnia u;
    public App(Uczelnia u){
        Rama rama = new Rama(900, 600);
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = new JPanel();
        JSplitPane p2 = new ListaOsob(u);
        JSplitPane p3 = new ListaKursow(u);
        tabbedPane.addTab("Lista Osob", p2);
        tabbedPane.addTab("Lista kursow", p3);
        rama.add(tabbedPane);
        rama.setup();


    }
}
