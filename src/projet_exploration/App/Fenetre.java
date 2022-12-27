package projet_exploration.App;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements KeyListener{
    public Grille G;
    public UI affichage;
    public Grille Grille_personnage;
    
    public JPanel panel;  
 
    public Fenetre(String str){
        super(str);
        this.addKeyListener(this);
//        panel= new JPanel();
//        panel.setSize(300,300);
//        panel.setBackground(Color.red);
//        panel.setOpaque(true);
//        this.add(panel); 
//        this.setVisible(true);
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
    	System.out.println(arg0);
    	System.out.println(String.format("%d %d", affichage.Persos.get(0).x,affichage.Persos.get(0).y));
        switch(arg0.getKeyChar()) {
        case 'q':
        	this.affichage.Persos.get(0).y--;
        break;
        case'z': this.affichage.Persos.get(0).x--;
    		break;
        case's':this.affichage.Persos.get(0).x++;
    		break;
        case'd': this.affichage.Persos.get(0).y++;
    		break;
        }
        affichage.repaint();
    }
}
