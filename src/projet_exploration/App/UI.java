package projet_exploration.App;
import projet_exploration.Cases.*;
import projet_exploration.Entity.Joueur;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
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
    public Combat combat;
    public String str;
    public String texte="";
    public String points="";
    public String tue="";
    
    public long finCombatTime = 0;
    private Font f = new Font(Font.SERIF,Font.BOLD,15);
    private Font f2 = new Font(Font.SERIF,Font.BOLD,30);
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
    		String info = "Appuie sur k pour lancer le dé !";
    		String viejoueur=String.valueOf(this.joueur.p.pv);
    		String viemonstre=String.valueOf(this.ennemieCombat.p.pv);
    		String lastAction=combat.deString();
    		
    		g2.setColor(Color.gray);
    		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    		g2.setFont(f);
    		g2.setColor(Color.white);
    		g2.drawString(cmbt, this.getWidth()/2-cmbt.length()*15/2,20);
    		g2.drawString(info, this.getWidth()/2-info.length()*15/2,60);
    		g2.drawString(viejoueur,0,this.getHeight()/2-100);
    		g2.drawString(viemonstre,this.getWidth()-100, this.getHeight()/2-100);
    		g2.drawString(lastAction,this.getWidth()/2-100,this.getHeight()/2-100);
    		Point pos = (Point) joueur.getPos().clone();
    		joueur.setPos(new Point((this.getHeight()/2/Case.size),0));
    		joueur.dessine(g2);
    		joueur.setPos(pos);
    		pos = (Point) ennemieCombat.getPos().clone();
    		ennemieCombat.setPos(new Point((this.getHeight()/2/Case.size),this.getWidth()/Case.size-1));
    		ennemieCombat.dessine(g2);
    		ennemieCombat.setPos(pos);
    		g2.drawImage(combat.deImage(),this.getWidth()/2-80,this.getHeight()/2-80,null);
    		
    		
    	}
    	
    	g2.setFont(f2);
    	g2.drawString(texte, this.getWidth()/2+100-texte.length()*15/2,50);
    	g2.drawString(points, this.getWidth()/2+100-texte.length()*15/2,100);
    	g2.drawString(tue, this.getWidth()/2+100-texte.length()*15/2,150);
    }
    	
  }
    
