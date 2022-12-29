package Evenements;

import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.Cases.Case;
import projet_exploration.Cases.CasePorte;

public class traverser extends Evenement {

	public traverser(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Game master) {
		// TODO Auto-generated method stub
		CasePorte c = (CasePorte)caller;
		master.frame.G = master.levels.get(c.niveauCible);
		master.affichage.G = master.frame.G;
		master.affichage.joueur.setPos(master.jsonLevels.get(c.niveauCible).getPorte(c.porteCible));
		master.affichage.Persos = master.jsonLevels.get(c.niveauCible).monstres;
	}

}
