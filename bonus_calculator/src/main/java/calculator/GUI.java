package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
    private final JFrame frame;
    private final JPanel panel;

    //constructor that creates the window
    public GUI(){
        frame = new JFrame();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,30,30,30));
        panel.setLayout(new GridLayout(0,1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Erevan Calculator");
        frame.pack();
        frame.setVisible(true);
    }
    //adds a label
    public JLabel addLabel(String text){
        JLabel label = new JLabel(text);
        panel.add(label);
        frame.pack();
        return label;
    }
}
