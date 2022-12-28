package projet_exploration.App;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import projet_exploration.Cases.Case;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import projet_exploration.Entity.Personnage;
import com.google.gson.stream.JsonReader;

public class Grille {
	public Case[][] map = null;
	
	//private Personnage Perso[]; 
//	public Grille(int x,int y) {
//		try {
//			int numberLine = x;
//			int sizeLine = y;
//
//			this.map = new Case[numberLine][sizeLine];
//			int i,j;
//
//			for(i=0; i<numberLine; i++)
//				for(j=0; j<sizeLine; j++)
//				{
//					this.map[i][j]=null;
//				}
//			
//			
//		}catch(Exception e) {e.printStackTrace();
//		
//		}
//	}
	
//	public static Grille fromJson(String filename) {
//		
//	}
	
	public static Grille fromArray(List<List<List<Integer>>> _m) {
		Grille G = new Grille();
		G.map = new Case[_m.size()][_m.get(0).size()];
		for(int i =0;i<_m.size();i++) {
			for(int j=0;j<_m.get(0).size();j++) {
				G.map[i][j] = Case.createCase(_m.get(i).get(j).get(0), i, j,_m.get(i).get(j));
			}
		}
		return G;
		
	}
	
	public static Grille fromTxt(String filename) {
		Path path;

		try {
			Grille G = new Grille();
			path = Paths.get(filename);
			List<String> lines = Files.readAllLines(path);
			int numberLine = lines.size(); //yavais -1
			int sizeLine = lines.get(1).length();

			G.map = new Case[numberLine][sizeLine];
			int i,j;

			for(i=0; i<numberLine; i++)
				for(j=0; j<sizeLine; j++)
				{
					G.map[i][j] = Case.createCase(Integer.parseInt(new String(lines.get(i).substring(j,j+1))),i,j,null); 
				}
			return G;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
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

