package RedLineGraphics;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener{
    private String name;
    private Image img;
    public Bouton(String str){
        super(str);
        this.name = str;
        try{
            img = ImageIO.read(new File("/home/gounaya/Documents/IntellijProject/Swing/src/RedLineGraphics/buttonGreen.png"));
        }catch(IOException e){
            System.out.println("exception Image !");
            e.printStackTrace();
        }
        /*grace à cette instruction au dessous, notre objet va s'écouter
        Dès qu'un evenement de la souris sera intercepté, il en sera averti*/
        this.addMouseListener(this);
    }
    /*
    Exemple with colors, not image -
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.white);
        g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
    }*/

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.black);
        g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() /  2 /4), (this.getHeight() / 2) + 5);
    }

    /*
    il aura une teinte jaune au survol de la souris ;
    il aura une teinte orangée lorsque l'on pressera le bouton gauche ;
    il reviendra à la normale si on relâche le clic.
     */

    //Méthode appelée lors de la clic de souris
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }
    //Méthode appelée lors du survol de la souris  -util-
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        //Nous changeons le fond de notre image pour le jaune lors du survol, avec le fichier buttonYellow.png
        try{
            img = ImageIO.read(new File("/home/gounaya/Documents/IntellijProject/Swing/src/RedLineGraphics/buttonYellow.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //Méthode appelée lorsque la souris sort de la zone du bouton
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        //Nous changeons le fond de notre image pour le vert lorsque nous quittons le bouton, avec le fichier buttonGreen.png
        try {
            img = ImageIO.read(new File("/home/gounaya/Documents/IntellijProject/Swing/src/RedLineGraphics/buttonGreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Méthode appelée lorsque l'on presse le bouton gauche de la souris  -util-
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        //Nous changeons le fond de notre image pour le jaune lors du clic gauche, avec le fichier buttonYellow.png
        try {
            img = ImageIO.read(new File("/home/gounaya/Documents/IntellijProject/Swing/src/RedLineGraphics/buttonYellow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Méthode appelée lorsque l'on relâche le clic de souris  -util-
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        //Nous changeons le fond de notre image pour le orange lorsque nous relâchons le clic, avec le fichier buttonBrun.png si la souris est toujours sur le bouton
        //Coordonnées x et y du cursus de la souris par rapport au Bouton grâce aux méthodes getX et getY
        try {
            img = ImageIO.read(new File("/home/gounaya/Documents/IntellijProject/Swing/src/RedLineGraphics/buttonBrun.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
