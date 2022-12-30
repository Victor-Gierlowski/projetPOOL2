package projet_exploration.App.wfc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import projet_exploration.App.json.fileLevelJSONObject;
import projet_exploration.App.json.levelJSONObject;


/**
 * Cette classe représente un générateur de niveau.
 * Il se base sur la fonction {@link projet_exploration.App.wfc.WaveFunctionCollapse#generate(int,int,List<wfcPattern>}
 * 
 * La classe est composé d'une grid 2D de pattern. Cela représente la carte
 * Ainsi que d'une List de Pattern. Cette liste contiendra à la suite 
 * les salles garder pour former le niveau.
 * 
 * Lorsque la classe génère un ensemble de salle, il l'enregistre dans un fichier json.
 * 
 * @author Victor GIERLOWSKI
 * @version 1.0
 */
public class Generator {
	public List<List<wfcPattern>> grid;
	public List<wfcPattern> masterLevel;

	/**
	 * Cette méthode va retourner la chaine de caractères correspondant
	 * au chemin vers le fichier où l'ensemble de salles à  été générer.
	 *
	 * @return String le chemin.
	 */
	public String generate() throws FileNotFoundException {	
		// GSON ----
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader("src\\projet_exploration\\App\\json\\structures.json"));
		ensembleStructure es = gson.fromJson(reader,ensembleStructure.class);
		//  WFC ----------
		WaveFunctionCollapse wfc = new WaveFunctionCollapse();
		grid = wfc.generer(2,2, es.structures);
		// --------
		
		// On récupère le plus grand chemin
		masterLevel = chercherLePlusGrandChemin(grid);
		//On affiche le chemin selectionner.
		for(int i =0;i<grid.size();i++) {
			for(int j=0;j<grid.get(i).size();j++) {
				String c =" ";
				if(grid.get(i).get(j) != null && masterLevel.contains(grid.get(i).get(j)))
					c = grid.get(i).get(j).toString();
				System.out.print(c);
			}
			System.out.println();
		}
		// On l'enregistre dans un fichier.
		return creerMasterFileJSON(masterLevel);
	}
	
	/**
	 * Cette méthode sert à créer le fichier maitre d'une partie
	 * c'est elle qui contient l'ensemble des salles.
	 * @param ens La liste des patterns correspondant aux salles à enregistrer
	 * @return String le chemin cible.
	 */
	public String creerMasterFileJSON(List<wfcPattern> ens) {
		fileLevelJSONObject master = new fileLevelJSONObject();
		master.room = new ArrayList<levelJSONObject>();
		master.degats = (int) Math.random()*5+2;
		master.health = (int) Math.random()*5+5;
		for(int i =0;i<grid.size();i++) {
			for(int j =0;j<grid.get(i).size();j++) {
				if(ens.contains(grid.get(i).get(j))) {
					master.room.add(
							creerLevelJSON(
							grid.get(i).get(j),
							nearest(-1,0,j,i),
							nearest(1,0,j,i),
							nearest(0,-1,j,i),
							nearest(0,1,j,i)
							));
				}
			}
		}
		String filename = String.format("levels/level%droom_%d.json",master.room.size(),System.currentTimeMillis()/1000);
		Gson gson = new Gson();
		String json = gson.toJson(master);
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write(json);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	
	
	/**
	 * Ici on va créer un objet json correspondant à une salle.
	 * 
	 * @param centre la salle à créer.
	 * @param gauche la salle à gauche de celle à créer.
	 * @param droite la salle à droite de celle à créer.
	 * @param bas la salle en bas de celle à créer.
	 * @param haut la salle en haut de celle à créer.
	 * @return levelJSONObject la salle créé.
	 */
	public levelJSONObject creerLevelJSON(wfcPattern centre,wfcPattern gauche,wfcPattern droite,wfcPattern haut,wfcPattern bas) {
		System.out.println(String.format("O%sO", (haut == null)?" ":haut));
		System.out.println(String.format("%s%s%s", (gauche==null)?" ":gauche,centre,(droite==null)?" ":droite));
		System.out.println(String.format("O%sO", (bas==null)?" ":bas));
		
		levelJSONObject level = new levelJSONObject();
		level.map = new ArrayList<List<List<Integer>>>();
		level.portes = new ArrayList<Point>();
		level.spawn = new ArrayList<Integer>();
		level.ennemies = new ArrayList<List<Integer>>();
		level.spawn.add(1);
		level.spawn.add(1);
		for(int i =0;i<centre.map.size();i++) {
			level.map.add(new ArrayList<List<Integer>>());
			for(int j=0; j < centre.map.get(0).size();j++) {
				level.map.get(i).add(new ArrayList<Integer>());
				if(centre.map.get(i).get(j) == 5) {
					System.out.println(String.format("%b %b %b %b", 
							bas == null, gauche == null, bas == null, droite == null));
					if(j == 0) {
						level.map.get(i).get(j).add(5);
						if(gauche !=null) {							
						level.map.get(i).get(j).add(masterLevel.indexOf(gauche));
						level.map.get(i).get(j).add(gauche.numPortePos(2,gauche.map.get(2).size()-1));
						}
					}
					if(j == centre.map.get(i).size()-1) {
						level.map.get(i).get(j).add(5);
						if(droite != null) {							
						level.map.get(i).get(j).add(masterLevel.indexOf(droite));
						level.map.get(i).get(j).add(droite.numPortePos(2,0));
						}
					}
					if(i == 0) {
						level.map.get(i).get(j).add(5);
						if(haut != null) {
							
						level.map.get(i).get(j).add(masterLevel.indexOf(haut));
						level.map.get(i).get(j).add(haut.numPortePos(haut.map.size()-1,2));
						}
					}
					if(i == centre.map.size()-1) {
						level.map.get(i).get(j).add(5);
						if(bas != null) {							
						level.map.get(i).get(j).add(masterLevel.indexOf(bas));
						level.map.get(i).get(j).add(bas.numPortePos(0,2));
						}
					}
					if(level.map.get(i).get(j).size() > 1) {						
						System.out.println(String.format("%d %d %d", level.map.get(i).get(j).get(0),level.map.get(i).get(j).get(1),level.map.get(i).get(j).get(2)));
						level.portes.add(new Point(i,j));
					}
				}
				else if(centre.map.get(i).get(j) == 0) {
					double r = Math.random();
					int c = 2;
					if(r<0.1) c = 4;
					level.map.get(i).get(j).add(c);
				}else
					level.map.get(i).get(j).add(1);
//			System.out.println(String.format("%d %d %d %d", level.map.get(i).get(j).size(),i,j,centre.map.get(i).get(j)));
			}
		}
		return level;
	}
	
	/**
	 * Cette méthode recherche dans une direction donnée, la salle la plus proche
	 * non null, et la retourne si elle peut se connecter dans la direction
	 * d'où on parcourt la grille; ou null.
	 * 
	 * 
	 * @param dx
	 * @param dy
	 * @param x
	 * @param y
	 * @return wfcPattern ou null.
	 */
	public wfcPattern nearest(int dx,int dy,int x,int y) {
		do{
			x+=dx;
			y+=dy;
			if(x <0 || x >= grid.get(0).size() || y < 0 || y >= grid.size()) return null;
			if(grid.get(y).get(x) != null) {
					if(masterLevel.contains(grid.get(y).get(x))) {						
						System.out.println(String.format("dx%d:dy:%d %s",
								dx,dy,grid.get(y).get(x)));
						if(dx == -1) {
							System.out.println(grid.get(x).get(y).right.contains(0));
							if(grid.get(y).get(x).right.contains(0))
								return grid.get(y).get(x);
						}
						else if(dx == 1) {
							System.out.println(grid.get(y).get(x).left.contains(0));
							if(grid.get(y).get(x).left.contains(0))
								return grid.get(y).get(x);
						}
						else if(dy == 1) {
							System.out.println(grid.get(y).get(x).top.contains(0));
							if(grid.get(y).get(x).top.contains(0))
								return grid.get(y).get(x);
						}
						else if(dy == -1){
							System.out.println(grid.get(y).get(x).bottom.contains(0));
							if(grid.get(y).get(x).bottom.contains(0))
								return grid.get(y).get(x);
						}
					}
					else return null;
			}
			}while(x > 0 && x < -1+grid.get(0).size() && y > 0 && y < -1+grid.size());
		
		return null;
	}
	/**
	 * Le but est de parcourir toutes les cases de la grille 2D;
	 * et pour chaque chemin indépendant trouver sa longueur et
	 * ne garder que le plus grnad.
	 * 
	 * @param l la grille 2D des patternes;
	 * @return List<wfcPattern> une liste de patterne contigue.
	 */
	public List<wfcPattern> chercherLePlusGrandChemin(List<List<wfcPattern>> l){
		List<wfcPattern> chemin = null;
		for(int i =0;i<l.size();i++) {
			for(int j=0;j<l.get(i).size();j++){
				List<wfcPattern> temp = null;
				if(l.get(i).get(j) != null && !l.get(i).get(j).used)
					temp = chercheChemin(l,l.get(i).get(j),i,j,null);
				if(chemin == null && temp != null || temp != null && temp.size() > chemin.size())
					chemin = temp;
			}
		}
		return chemin;
	}
	
	
	/**
	 * On essaie de suivre le chemin dans toutes ses direction et on compte le total
	 * de patterne qui le constituent.
	 */
	public List<wfcPattern> chercheChemin(List<List<wfcPattern>> ens, wfcPattern p,int x,int y, List<wfcPattern> e){
		if(e == null)
			e= new ArrayList<wfcPattern>();
		if( p == null|| e.contains(p) || p.used) return e;
		else {
			e.add(p);
			p.used = true;
		}
		if(p.top.contains(0) && x-1 >= 0)
			chercheChemin(ens,ens.get(x-1).get(y),x-1,y,e);
		if(p.bottom.contains(0) && x+1 < ens.size())
			chercheChemin(ens,ens.get(x+1).get(y),x+1,y,e);
		if(p.left.contains(0) && y-1 >= 0)
			chercheChemin(ens,ens.get(x).get(y-1),x,y-1,e);
		if(p.right.contains(0) && y+1 < ens.get(0).size())
			chercheChemin(ens,ens.get(x).get(y+1),x,y+1,e);
		return e;
		
	}

}


class ensembleStructure {
	public List<wfcPattern> structures;
}