package Evenements;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.Cases.Case;

public class nextLevel extends Evenement {

	public nextLevel(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void action(Game master) {
		master.frame.affichage.texte="BRAVO VOUS ETES SORTI \n";
		master.frame.affichage.points="Vous avez vaincus: "+master.frame.joueur.totaltue/2+" monstres!\n";
		master.frame.affichage.tue="Vous avez obtenu: "+master.frame.joueur.points+" points";
		
	
		// TODO Auto-generated method stub
		

	}

}
