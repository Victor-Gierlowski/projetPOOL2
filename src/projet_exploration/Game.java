package projet_exploration;

import projet_exploration.App.*;
import javax.swing.JFrame;
import java.awt.*;

import projet_exploration.App.Grille;

public class Game {

	public static void main(String[] args) {
		Grille G;
		UI affichage = new UI();
		Fenetre frame = new Fenetre("notre jeu");
		frame.setSize(825,850);
		frame.setLocation(300,300);
		frame.G = Grille.readGrilleFile("level1.txt");
		affichage.map = frame.G.map;
		frame.add(affichage);
		int i,j;


		for(i=0; i<frame.G.map.length; i++) {
			for(j=0; j<frame.G.map[0].length; j++) {
				System.out.print(frame. G.map[i][j].toString() );
				// frame.add(G.map[i][j]);
			}
			System.out.println();
		}
		frame.setVisible(true);

	}

}

//JFRAME JPANEL JBUTTON POUR L INTERFACE GRAPHIQUE
