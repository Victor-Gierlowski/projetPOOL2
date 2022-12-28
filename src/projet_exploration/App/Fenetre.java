package projet_exploration.App;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;

import projet_exploration.Entity.Joueur;

public class Fenetre extends JFrame implements KeyListener{
    public Grille G;
    public UI affichage;
    public Joueur joueur;
    public JPanel panel;  
    
    public Game master;
 
    public Fenetre(String str, Game m){
        super(str);
        this.addKeyListener(this);
        this.master = m;
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
    	Point jPos = affichage.getJoueur().getPos();
    	switch(arg0.getKeyChar()) {
        case 'q':
        	jPos.translate(0, -1);
        	if(G.isMovable(jPos))	
        		affichage.getJoueur().setPos(jPos);
        	break;
        case'z':
        	jPos.translate(-1, 0);
        	if(G.isMovable(jPos)) 
        		affichage.getJoueur().setPos(jPos);
        	break;
        case's':
        	jPos.translate(1,0);
        	if(G.isMovable(jPos))
        		affichage.getJoueur().setPos(jPos);
    		break;
        case'd':
        	jPos.translate(0,1);
        	if(G.isMovable(jPos))
        		affichage.getJoueur().setPos(jPos);
    		break;
        }
    	if(G.isMovable(jPos)) {    		
    		Evenement E = G.map[jPos.x][jPos.y].playerOnCase();
    		if(E != null)
    			E.action(master);
    	}
        affichage.repaint();
    }
}
