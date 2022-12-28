package projet_exploration.App;
import projet_exploration.Cases.*;
import projet_exploration.Entity.Joueur;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class UI extends JPanel{
    public Grille G;
    public List<CasePerso> Persos;
    private Integer joueurIndex;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<G.map.length;i++){
            for(int j =0;j<G.map[0].length;j++){
            	G.map[i][j].dessine((Graphics2D)g);
            }
        }
        for(int i=0;i<Persos.size();i++) {
        	Persos.get(i).dessine((Graphics2D)g);;
        }
    }
    
    public CasePerso getJoueur() {
    	if(this.joueurIndex != null)
    		return this.Persos.get(joueurIndex);
    	int i;
    	for(i=0;i<this.Persos.size();i++) {
    		if(true) {
    			this.joueurIndex = i;
    			break;
    		}
    	}
		return this.Persos.get(joueurIndex);
    }
}
