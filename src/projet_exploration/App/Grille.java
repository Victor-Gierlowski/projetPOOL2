package projet_exploration.App;

import java.awt.Point;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import projet_exploration.Cases.Case;
//import projet_exploration.Entity.Personnage;

public class Grille {
	public Case[][] map = null;
	//private Personnage Perso[]; 
	
	public Grille(int x,int y) {
		try {
			int numberLine = x;
			int sizeLine = y;

			this.map = new Case[numberLine][sizeLine];
			int i,j;

			for(i=0; i<numberLine; i++)
				for(j=0; j<sizeLine; j++)
				{
					this.map[i][j]=null;
				}
			
			
		}catch(Exception e) {e.printStackTrace();
		
		}
	}
	public Grille (String filename) {
		Path path;

		try {
			path = Paths.get(filename);
			List<String> lines = Files.readAllLines(path);
			int numberLine = lines.size(); //yavais -1
			int sizeLine = lines.get(1).length();

			this.map = new Case[numberLine][sizeLine];
			int i,j;

			for(i=0; i<numberLine; i++)
				for(j=0; j<sizeLine; j++)
				{
					this.map[i][j] = Case.createCase(Integer.parseInt(new String(lines.get(i).substring(j,j+1))),i,j); 
				}
		}catch(Exception e) {e.printStackTrace();
		
		}
		
	}
			
	public int getWidth(){
		return this.map[0].length;
	}
	public int getHeight(){
		return this.map.length;
	}
	public boolean isMovable(Point pos) {
		if(pos.x < 0 || pos.x > this.getWidth()
		|| pos.y < 0 || pos.y > this.getHeight()) return false;
		return (map[pos.x][pos.y].isMovable());
	}
}
