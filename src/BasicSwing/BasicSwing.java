package BasicSwing;

import javax.swing.*;

public class BasicSwing extends JFrame{

    JPanel p = new JPanel();
    JButton b= new JButton("Hello");
    JTextField tf = new JTextField("hi",20);
    JTextArea ta = new JTextArea("How\nare\nyou",5,20);
    JLabel jl = new JLabel("Whats'up");
    String choices[]={
            "Hello",
            "Bonjour",
            "Ciao"
    };
    JComboBox cb = new JComboBox(choices);


    public static void main(String[] args) {
        new BasicSwing();
    }

    public BasicSwing() {
        super("Basic swing app");

        setSize(400,300);
        setResizable(true);
        setVisible(true);
        p.add(b);
        p.add(tf);
        p.add(ta);
        p.add(jl);
        p.add(cb);
        add(p);

        setVisible(true);

    }


}