package projet_exploration.App;

import projet_exploration.App.json.fileLevelJSONObject;
import projet_exploration.App.json.levelJSONObject;
import projet_exploration.App.wfc.Generator;
import projet_exploration.Cases.*;
import projet_exploration.Entity.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Game  implements Runnable{
	public Fenetre frame;
	public List<Grille> levels;
	public UI affichage;
	public fileLevelJSONObject jsonMaster;
	public List<levelJSONObject> jsonLevels;
	public Joueur joueur;

	private long lastFrame = 0;
	public void start(String level) {
		//Définie l'objet affichage qui gère l'interface
		affichage = new UI();
		// La fenetre
		frame = new Fenetre("notre jeu",this);
		//Définit la taille de notre fenetre et sa position d'apparition
		frame.setSize(1000,800);
		frame.setLocation(200,200);
		//frame.G = Grille.fromTxt("level1.txt");


		//Ici on lis un fichier json qui contient des salles contigue
		if(level.length() == 0)
			try {
				level = new Generator().generate();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.load(level);
	}
	
	public void load(String level) {
		
		
		
		System.out.println(level);
		this.loadLevelFromJSON(level);
		//On définit la grille de travail et d'affichage sur celle 
		//du premier niveau
		frame.G = levels.get(0);
		affichage.G = frame.G;

		//On récupère la position d'apparition du joueur
		Point s = jsonLevels.get(0).getSpawn();
		//On créer le joueur et le stock dans game.joueur
		this.joueur = new Joueur(jsonMaster.health,jsonMaster.degats);
		//On créer la CASE du joueur aux positions de spawn,
		//et en la reliant au joueur.
		CasePerso joueur = new CasePerso(s.x, s.y, ((Personnage)this.joueur));
		//On définit le tableau des ennemies
		affichage.Persos = new ArrayList<CasePerso>();
		//On modifie pour dire que les cases sur lesquelles
		//spawn les monstres, on ne peut pas marcher
		//car déjà occupé
		//(uniquement utile tour 1
		for(CasePerso m : affichage.Persos) {
			affichage.G.map[m.x][m.y].movable =false;
		}
		//On fait le lien pour la CASE joueur dans affichage
		//donc la même que frame | UI & fenetre
		affichage.joueur = joueur;
		//On définit les monstres sur les monstre du niveau
		affichage.Persos = jsonLevels.get(0).monstres;

		// Frame n'a pas besoin de la case mais
		// du joueur car interraction de jeu pas affichage.
		frame.joueur = (Joueur) joueur.getP();
		//On ajoute le système d'affichage à la fentre
		frame.add(affichage);
		//On rajoute le lien entre la fenetre et l'affichage
		frame.affichage = affichage;

		int i,j;


		for(i=0; i<frame.G.map.length; i++) {
			for(j=0; j<frame.G.map[0].length; j++) {
				System.out.print(frame. G.map[i][j].toString());
				// frame.add(G.map[i][j]);
			}
			System.out.println();
		}

		

		frame.setVisible(true);
		this.run();
	}

	public void loadLevelFromJSON(String filename) {
		Gson gson = new Gson();
		Grille G = new Grille();
		try {
			JsonReader reader = new JsonReader(new FileReader(filename));
			jsonMaster = gson.fromJson(reader, fileLevelJSONObject.class);
			reader.close();
			if(jsonMaster == null) return;
			this.jsonLevels = new ArrayList<levelJSONObject>();
			this.levels = new ArrayList<Grille>();
			for(levelJSONObject level : jsonMaster.room) {
				level.setupPortes();
				level.setupMonstre();
				this.jsonLevels.add(level);
				this.levels.add(Grille.fromArray(level.map));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.frame.isShowing()) {
			// 1s => 1000ms
			// 1000ms / 30 img=> 33ms / img
			if(System.currentTimeMillis()-lastFrame>=33) {
				this.affichage.repaint();
				lastFrame = System.currentTimeMillis();
			}
		}
	}

}



