package projet_exploration.App;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements KeyListener{
    public Grille G;
    public Grille Grille_personnage;
    
    public JPanel panel;  
 
    public Fenetre(String str){
        super(str);
        
//        panel= new JPanel();
//        panel.setSize(300,300);
//        panel.setBackground(Color.red);
//        panel.setOpaque(true);
//        this.add(panel); 
//        this.setVisible(true);
        
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
        case 'q': panel.setLocation(panel.getX()-300,panel.getY());
        	break;
        case'z': panel.setLocation(panel.getX(),panel.getY()-300);
    		break;
        case's':panel.setLocation(panel.getX(),panel.getY()+300);
    		break;
        case'd': panel.setLocation(panel.getX()+300,panel.getY());
    		break;
        
        }
        
    }
}
