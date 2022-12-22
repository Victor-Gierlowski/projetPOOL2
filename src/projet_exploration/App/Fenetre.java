package projet_exploration.App;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame implements KeyListener{
    public Grille G;
    
    JLabel label;  
 
    public Fenetre(String str){
        super(str);
        
        label= new JLabel();
        label.setSize(300,300);
        label.setBackground(Color.red);
        label.setOpaque(true);
        
        this.add(label);
        this.setVisible(true);
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        switch(arg0.getKeyChar()) {
        case 'q': label.setLocation(label.getX()-100,label.getY());
        	break;
        case'z': label.setLocation(label.getX(),label.getY()-100);
    		break;
        case's':label.setLocation(label.getX(),label.getY()+100);
    		break;
        case'd': label.setLocation(label.getX()+100,label.getY());
    		break;
        
        }
        
    }
}
