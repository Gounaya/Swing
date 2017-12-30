package BorderLayoutMiniApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameApp extends JFrame implements ActionListener{
    //Logic
    Primes primes=new Primes(1000);
    byte process=0;
	/*
	0:inactive
	1:test
	2:list
	*/

    boolean stop=false;
    int numPrimes=0;
    int numProgress=0;
    String text="";

    //One panel contrains everything - General panel
    JPanel p= new JPanel();

    //center
    JTextArea primes_list = new JTextArea();
    JScrollPane primes_scroll = new JScrollPane(primes_list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    //west
    JPanel west = new JPanel(); //contains buttons
    JButton test = new JButton("Test");
    JButton list = new JButton("List");
    JButton clear = new JButton("Clear");

    //south
    JPanel south = new JPanel();
    JLabel inputlabel = new JLabel("Input");
    JTextField input = new JTextField(10); // We need just one line, that why we doesn't use the JTextArea
    JProgressBar progressBar = new JProgressBar();
    JLabel primesFoundLabel = new JLabel("Primes Found");
    JTextField primesFound = new JTextField(10);

    public FrameApp() {
        super("Prime Generation");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new BorderLayout());

        //prime number output
        primes_list.setEditable(false);
        primes_list.setLineWrap(true); //to wrappe if the lines is too long to fit within the allocated width
        primes_list.setWrapStyleWord(true);//Sets the style of wrapping used if the text area is wrapping lines.
        p.add(primes_scroll, BorderLayout.CENTER);

        //buttons - west
        west.setLayout(new GridLayout(10, 1));
        {
            test.addActionListener(this);
            list.addActionListener(this);
            clear.addActionListener(this);
        }
        west.add(test);
        west.add(list);
        west.add(clear);
        p.add(west, BorderLayout.WEST);

        //progreess - south
        progressBar.setString("Waiting");
        progressBar.setStringPainted(true);
        primesFound.setEditable(false);

        south.add(inputlabel);
        south.add(input);
        south.add(progressBar);
        south.add(primesFoundLabel);
        south.add(primesFound);
        p.add(south, BorderLayout.SOUTH);
        add(p);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        Object src = a.getSource();
        //test
        if(src.equals(test)){
            process = 1;
            int num = Integer.parseInt(input.getText());
            //ensures that primes object has a long enough range
            if (primes.getLength()<num){
                primes= new Primes(num,primes);
            }
            //finds prime from object
            if(primes.test(num)){
                print(num+" in prime");
                primesFound.setText("1");
            }else{
                print(num+" is not prime");
                primesFound.setText("0");
            }
            printEnd();
            process = 0;
        }
        //list
        if(src.equals(list)){
            switch (process){
                case 0 :
                    process = 2;
                    stop = false;
                    Thread th = new Thread(new List(this));
                    th.start();
                    list.setText("Stop");
                    break;
                case 2 :
                    stop = true;
                    break;

            }
        }
        //clear
        if(src.equals(clear)){

        }
    }

    public void print(String text){
        int pos = primes_list.getText().length();
        primes_list.insert(text,pos);
        System.out.println(text);
    }

    public void printEnd(){
        print("\n\n-------------------------------------------------------\n\n");

    }
}