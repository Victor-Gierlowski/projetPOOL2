package projet_exploration.App;

import projet_exploration.App.json.fileLevelJSONObject;
import projet_exploration.App.json.levelJSONObject;
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
	public void start(String[] args) {
		affichage = new UI();
		frame = new Fenetre("notre jeu",this);
        frame.setSize(1000,800);
        frame.setLocation(200,200);
        //frame.G = Grille.fromTxt("level1.txt");
        this.loadLevelFromJSON("levels/level1.json");
        frame.G = levels.get(0);
        affichage.G = frame.G;

        ImageIcon perso = new ImageIcon("./img/personnage1.png");
        Point s = jsonLevels.get(0).getSpawn();
        this.joueur = new Joueur(jsonMaster.health,jsonMaster.degats);
        CasePerso joueur = new CasePerso(s.x, s.y, ((Personnage)this.joueur));
        affichage.Persos = new ArrayList<CasePerso>();
        for(CasePerso m : affichage.Persos) {
        	affichage.G.map[m.x][m.y].movable =false;
        }
        affichage.joueur = joueur;
        affichage.Persos = jsonLevels.get(0).monstres;
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
		this.run();
	}
	
	public void loadLevelFromJSON(String filename) {
		Gson gson = new Gson();
		Grille G = new Grille();
		try {
			JsonReader reader = new JsonReader(new FileReader(filename));
			jsonMaster = gson.fromJson(reader, fileLevelJSONObject.class);
			if(jsonMaster == null) return;
			this.jsonLevels = new ArrayList<levelJSONObject>();
			this.levels = new ArrayList<Grille>();
			for(levelJSONObject level : jsonMaster.room) {
				level.setupPortes();
				level.setupMonstre();
				this.jsonLevels.add(level);
				this.levels.add(Grille.fromArray(level.map));
			}
		} catch (FileNotFoundException e) {
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



