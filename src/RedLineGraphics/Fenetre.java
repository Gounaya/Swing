package RedLineGraphics;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Fenetre extends JFrame implements ActionListener{
    private panneau pan = new panneau();
    private Bouton bouton = new Bouton("mon bouton");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("LabelAction");

    private int compteur = 0;


    public Fenetre(){
        this.setTitle("Animation");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        container.add(bouton, BorderLayout.SOUTH);
        container.add(label, BorderLayout.NORTH);

        bouton.addActionListener(this);

        //Modif about new label:
            //Définition d'une police d'ecriture
            Font police = new Font("Tahoma", Font.BOLD, 16);
            //On l'applique au JLabel
            label.setFont(police);
            //Changement de la couleur du texte
            label.setForeground(Color.blue);
            //On modifie l'alignement du texte grâce aux attributs statiques
            //de la classe JLabel
            label.setHorizontalAlignment(JLabel.CENTER);

        this.setContentPane(container);
        this.setVisible(true);
        go();
    }


    private void go(){
        //Les coordonnées de départ de notre rond
        int x = pan.getPosX(), y = pan.getPosY();
        //Le booléen pour savoir si l'on recule ou non sur l'axe x
        boolean backX = false;
        //Le booléen pour savoir si l'on recule ou non sur l'axe y
        boolean backY = false;

        //Dans cet exemple, j'utilise une boucle while
        //Vous verrez qu'elle fonctionne très bien
        while(true){
            //Si la coordonnée x est inférieure à 1, on avance
            if(x < 1)backX = false;
            //Si la coordonnée x est supérieure à la taille du Panneau moins la taille du rond, on recule
            if(x > pan.getWidth()-50)backX = true;
            //Idem pour l'axe y
            if(y < 1)backY = false;
            if(y > pan.getHeight()-50)backY = true;

            //Si on avance, on incrémente la coordonnée
            if(!backX)
                pan.setPosX(++x);
                //Sinon, on décrémente
            else
                pan.setPosX(--x);
            //Idem pour l'axe Y
            if(!backY)
                pan.setPosY(++y);
            else
                pan.setPosY(--y);

            //On redessine notre Panneau
            pan.repaint();
            //Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //méthode qui sera appelée lors d'un clic sur le bouton
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //lorsqu'on clique sur le bouton, on met à jour le label
        this.compteur++;
        label.setText("Vous avez cliqué "+this.compteur+" fois");
    }
}
    /*
    Simple methode go qui réinitialiser les coordonnées
    du rond lorsqu'elles atteignent le bout de notre composant.
    private void go(){
  for(;;){
    int x = pan.getPosX(), y = pan.getPosY();
    x++;
    y++;
    pan.setPosX(x);
    pan.setPosY(y);
    pan.repaint();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //Si nos coordonnées arrivent au bord de notre composant
    //On réinitialise
    if(x == pan.getWidth() || y == pan.getHeight()){
      pan.setPosX(-50);
      pan.setPosY(-50);
    }
  }
}
     */
