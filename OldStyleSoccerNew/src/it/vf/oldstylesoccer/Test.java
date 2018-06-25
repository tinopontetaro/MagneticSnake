package it.vf.oldstylesoccer;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class Test extends JFrame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JWindow window = new JWindow();
                final Viewer splash = new Viewer();
                window.add(splash);
                window.setSize(100, 30);
                window.setVisible(true);

                new Thread() {

                    @Override
                    public void run() {
//                        splash.startt();
                    }
                }.start();
            }
        });
    }
}