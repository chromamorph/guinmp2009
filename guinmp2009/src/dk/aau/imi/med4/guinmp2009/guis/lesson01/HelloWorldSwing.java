package dk.aau.imi.med4.guinmp2009.guis.lesson01;

import javax.swing.*;        

public class HelloWorldSwing {
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("HelloWorldSwing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JLabel label = new JLabel("Hello World");
                frame.getContentPane().add(label);
                frame.getContentPane().remove(label);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
