package projet_exploration.App;
import projet_exploration.Cases.*;
import projet_exploration.Entity.Joueur;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UI extends JPanel{
    public Grille G;
    public List<CasePerso> Persos;
    public CasePerso joueur;
    public CasePerso ennemieCombat;
    public boolean modeCombat = false;
    
    private Font f = new Font(Font.SERIF,Font.BOLD,15);
    public void paintComponent(Graphics g){
    	Graphics2D g2 = (Graphics2D)g;
    	if(!modeCombat) {
    		
        super.paintComponent(g);
        for(int i=0;i<G.map.length;i++){
            for(int j =0;j<G.map[0].length;j++){
            	G.map[i][j].dessine((Graphics2D)g);
            }
        }
        for(int i=0;i<Persos.size();i++) {
        	Persos.get(i).dessine((Graphics2D)g);;
        }
        joueur.dessine((Graphics2D)g);
    	}
    	else {
    		String cmbt = "COMBAT !";
    		g2.setColor(Color.black);
    		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    		g2.setFont(f);
    		g2.setColor(Color.white);
    		g2.drawString(cmbt, this.getWidth()/2-cmbt.length()*15/2,20);
    		Point pos = (Point) joueur.getPos().clone();
    		joueur.setPos(new Point((this.getHeight()/2/Case.size),0));
    		joueur.dessine(g2);
    		joueur.setPos(pos);
    		pos = (Point) ennemieCombat.getPos().clone();
    		ennemieCombat.setPos(new Point((this.getHeight()/2/Case.size),this.getWidth()/Case.size-1));
    		ennemieCombat.dessine(g2);
    		ennemieCombat.setPos(pos);
    	}
    }
    
}
