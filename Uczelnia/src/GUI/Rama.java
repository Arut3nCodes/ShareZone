package GUI;

import javax.swing.JFrame;
import java.awt.*;

public class Rama extends JFrame{
    public Rama(int width, int height){
        super("Program zarzadzajacy uczelnia");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setup(){
        this.setVisible(true);
        this.setResizable(false);
    }
}
