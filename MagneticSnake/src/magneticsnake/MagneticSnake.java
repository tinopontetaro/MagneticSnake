package magneticsnake;

import javax.swing.*;
import magneticsnake.graphics.MagneticSnakePanel;

public class MagneticSnake {

    public MagneticSnake() {
        
    }
    
    public static void main(String[] args) {
        MagneticSnakePanel p = new MagneticSnakePanel();
        JFrame f = new JFrame();
        f.add(p);
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Magnetic Snake");
        
    }
    
    
}