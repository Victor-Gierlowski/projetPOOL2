package projet_exploration;


public class Game {

	public static void main(String[] args) {
		Case tabCase[][];

		tabCase = Case.readCaseFile("/home/mael/eclipse-workspace/projet_exploration/level1.txt");
		int i,j;

		for(i=0; i<tabCase.length; i++) {
			for(j=0; j<tabCase[0].length; j++) {
				System.out.print( tabCase[i][j].toString() );
			}
			System.out.println();
		}

	}

}

//JFRAME JPANEL JBUTTON POUR L INTERFACE GRAPHIQUE
