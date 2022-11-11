package projet_exploration;


public class Game {

	public static void main(String[] args) {
		Grille G;

		G = Grille.readGrilleFile("level1.txt");
		int i,j;

		for(i=0; i<G.map.length; i++) {
			for(j=0; j<G.map[0].length; j++) {
				System.out.print( G.map[i][j].toString() );
			}
			System.out.println();
		}

	}

}

//JFRAME JPANEL JBUTTON POUR L INTERFACE GRAPHIQUE
