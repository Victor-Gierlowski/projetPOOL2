package projet_exploration.App;

import projet_exploration.Cases.*;
import projet_exploration.Entity.Joueur;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.util.ArrayList;

public class Game {
		public Fenetre frame;
	public void start(String[] args) {
		UI affichage = new UI();
		frame = new Fenetre("notre jeu");
        frame.setSize(800,800);
        frame.setLocation(300,300);
        frame.G = new Grille("level1.txt");
        affichage.map = frame.G.map;
        frame.Grille_personnage = new Grille(5,5);

        ImageIcon perso = new ImageIcon("./img/personnage1.png");
        CasePerso joueur = new CasePerso(1,1, new Joueur(1, 1));
        affichage.Persos = new ArrayList<CasePerso>();
        affichage.Persos.add(joueur);
        frame.joueur = (Joueur) joueur.getP();
        frame.add(affichage);
        frame.affichage = affichage;
        
		int i,j;


		for(i=0; i<frame.G.map.length; i++) {
			for(j=0; j<frame.G.map[0].length; j++) {
				System.out.print(frame. G.map[i][j].toString());
				// frame.add(G.map[i][j]);
			}
			System.out.println();
		}
		
		JPanel panel;  
		frame.panel= new JPanel();
        frame.panel.setSize(300,300);
        frame.panel.setBackground(Color.red);
        frame.panel.setOpaque(true);
        frame.panel.setVisible(true);
        
		
		frame.setVisible(true);

	}

}

//JFRAME JPANEL JBUTTON POUR L INTERFACE GRAPHIQUE
