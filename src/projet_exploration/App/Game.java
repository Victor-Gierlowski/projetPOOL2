package projet_exploration.App;

import projet_exploration.App.json.fileLevelJSONObject;
import projet_exploration.App.json.levelJSONObject;
import projet_exploration.Cases.*;
import projet_exploration.Entity.Joueur;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class Game {
		public Fenetre frame;
		public List<Grille> levels;
		public UI affichage;
		
		public List<levelJSONObject> jsonLevels;
	public void start(String[] args) {
		affichage = new UI();
		frame = new Fenetre("notre jeu",this);
        frame.setSize(800,800);
        frame.setLocation(300,300);
        //frame.G = Grille.fromTxt("level1.txt");
        this.loadLevelFromJSON("levels/level1.json");
        frame.G = levels.get(0);
        affichage.G = frame.G;

        ImageIcon perso = new ImageIcon("./img/personnage1.png");
        Point s = jsonLevels.get(0).getSpawn();
        CasePerso joueur = new CasePerso(s.x,s.y, new Joueur(s.x, s.y));
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
	
	public void loadLevelFromJSON(String filename) {
		Gson gson = new Gson();
		Grille G = new Grille();
		try {
			JsonReader reader = new JsonReader(new FileReader(filename));
			fileLevelJSONObject file = gson.fromJson(reader, fileLevelJSONObject.class);
			if(file == null) return;
			this.jsonLevels = new ArrayList<levelJSONObject>();
			this.levels = new ArrayList<Grille>();
			for(levelJSONObject level : file.room) {
				level.setupPortes();
				this.jsonLevels.add(level);
				this.levels.add(Grille.fromArray(level.map));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



