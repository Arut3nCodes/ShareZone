package GUI;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JComponent;
import Osoba.*;

public class DodajStudenta {
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    Student s;



    DodajStudenta(){
        JTextField imie = new JTextField(5);
        JTextField nazwisko = new JTextField(5);
        JTextField pesel = new JTextField(5);
        JTextField wiek = new JTextField(5);
        JTextField plec = new JTextField(5);
        JTextField nrIndeksu = new JTextField(5);
        JTextField czyErasmus = new JTextField(5);
        JTextField czyStudentStopnia = new JTextField(5);
        JTextField czyStudentStacjonarny = new JTextField(5);

        p.add(new JLabel("Imie"));
        p.add(imie);
        p.add(new JLabel("Nazwisko"));
        p.add(nazwisko);
        p.add(new JLabel("Pesel"));
        p.add(pesel);
        p.add(new JLabel("Wiek"));
        p.add(wiek);
        p.add(new JLabel("Plec"));
        p.add(plec);
        p.add(new JLabel("nrIndeksu"));
        p.add(nrIndeksu);
        p.add(new JLabel("czyErasmus"));
        p.add(czyErasmus);
        p.add(new JLabel("czyStudentStopnia"));
        p.add(czyStudentStopnia);
        p.add(new JLabel("czyStudentStacjonarny"));
        p.add(czyStudentStacjonarny);

        int result = JOptionPane.showConfirmDialog(null, p,
                "Wpisz dane studenta", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            s = new Student(imie.getText(), nazwisko.getText(), pesel.getText(), Integer.parseInt(wiek.getText()), Boolean.parseBoolean(plec.getText()), Integer.parseInt(nrIndeksu.getText()), Boolean.parseBoolean(czyErasmus.getText()), Boolean.parseBoolean(czyStudentStopnia.getText()), Boolean.parseBoolean(czyStudentStacjonarny.getText()));
        }
    }
}
