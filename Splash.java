import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    Splash()
    {
        setSize(1200,700);
        setLocation(170,60);
        setResizable(false);
        setLayout(null);

        ImageIcon spl= new ImageIcon("Images\\Splash.png");
        JLabel splash = new JLabel(spl);
        splash.setBounds(0,0,1200,700);
        add(splash);


        JButton next = new JButton("Login");
        next.setBounds(270,400,180,40);
        next.setBackground(Color.white);

        splash.add(next);
        next.addActionListener(this);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        dispose();
        new Form();
    }
    public static void main(String[] args) {
        new Splash();
    }
}