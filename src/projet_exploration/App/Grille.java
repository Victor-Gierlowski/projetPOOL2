package projet_exploration.App;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import projet_exploration.Cases.Case;
//import projet_exploration.Entity.Personnage;

public class Grille {
	public Case[][] map = null;
	//private Personnage Perso[]; 
	
	
	public static Grille readGrilleFile(String filename) {
		Grille G = new Grille();
		Path path;

		try {
			path = Paths.get(filename);
			List<String> lines = Files.readAllLines(path);
			int numberLine = lines.size()-1;
			int sizeLine = lines.get(1).length();

			G.map = new Case[numberLine][sizeLine];
			int i,j;

			for(i=0; i<numberLine; i++)
				for(j=0; j<sizeLine; j++)
				{
					G.map[i][j] = Case.createCase(Integer.parseInt(new String(lines.get(i).substring(j,j+1))),i,j); 
				}
		}catch(Exception e) {e.printStackTrace();}

		return G;
	}

	public int getWidth(){
		return this.map[0].length;
	}
	public int getHeight(){
		return this.map.length;
	}
}
