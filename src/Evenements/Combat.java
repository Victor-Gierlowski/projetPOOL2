package Evenements;

import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.Cases.Case;
import projet_exploration.Cases.CasePerso;

public class Combat extends Evenement {

	public Combat(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Game master) {
		// TODO Auto-generated method stub
		master.affichage.modeCombat =true;
		master.affichage.ennemieCombat = (CasePerso)caller;
	}

}
