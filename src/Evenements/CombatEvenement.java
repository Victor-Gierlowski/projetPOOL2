package Evenements;

import projet_exploration.App.Combat;
import projet_exploration.App.Evenement;
import projet_exploration.App.Game;
import projet_exploration.Cases.Case;
import projet_exploration.Cases.CasePerso;
import projet_exploration.Entity.Monstre;

public class CombatEvenement extends Evenement {

	public CombatEvenement(Case c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(Game master) {
		// TODO Auto-generated method stub
		master.affichage.modeCombat =true;
		master.affichage.ennemieCombat = (CasePerso)caller;
		master.affichage.combat = new Combat(master.joueur,(Monstre)((CasePerso)caller).p, master.affichage);
	}

}
