package TicTacGame;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XOButton extends JButton implements ActionListener{
    ImageIcon X,O;
    byte value= 0;
    /*
    0 : nothing
    1 : X
    2 : O
     */

    public XOButton(){
        X= new ImageIcon(this.getClass().getResource("X.png"));
        O= new ImageIcon(this.getClass().getResource("Y.png"));
        this.addActionListener(this);
    }
    public void ActionPerformed(ActionEvent e){

    }

}
