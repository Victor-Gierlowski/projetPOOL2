package projet_exploration;

import projet_exploration.App.*;
import projet_exploration.Cases.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import projet_exploration.App.Grille;

public class Game {

	public static void main(String[] args) {
		//Grille G; pas besoin car dans UI;
		UI affichage = new UI();
		Fenetre frame = new Fenetre("notre jeu");
        frame.setSize(1200,1200);
        frame.setLocation(300,300);
        frame.G = new Grille("level1.txt");
        affichage.map = frame.G.map;
        frame.Grille_personnage = new Grille(5,5);

     // parti avec le perso
        ImageIcon perso = new ImageIcon("./img/personnage1.png");
        JLabel ok =  new JLabel();
        CasePerso perso1 = new CasePerso(1,1);
        ok.setIcon(perso);
        // ajoute le perso
        //affichage.add(ok);
        frame.Grille_personnage.map[1][1]=perso1;
        
        //ET LA çA MERDE ... 
     

        frame.add(affichage);
        
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
